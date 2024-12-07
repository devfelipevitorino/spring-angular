package com.helpdesk.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helpdesk.app.DTO.ClienteDTO;
import com.helpdesk.app.entity.Cliente;
import com.helpdesk.app.entity.Pessoa;
import com.helpdesk.app.exceptions.DataIntegrityViolationException;
import com.helpdesk.app.exceptions.ObjectNotFoundException;
import com.helpdesk.app.repositories.ClienteRepository;
import com.helpdesk.app.repositories.PessoaRepository;

import jakarta.validation.Valid;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder enconder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDto) {
		objDto.setId(null);
		objDto.setSenha(enconder.encode(objDto.getSenha()));
		validaEmailECpf(objDto);
		Cliente newObj = new Cliente(objDto);
		return repository.save(newObj);
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaEmailECpf(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Cliente obj = findById(id);
		
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Não é possivel deletar o técnico com ordens de serviços vinculadas!");
		}
		
		repository.deleteById(id);
		
	}

	private void validaEmailECpf(ClienteDTO objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
		}
		
		obj = pessoaRepository.findByEmail(objDto.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema");
		}
	}

	
}
