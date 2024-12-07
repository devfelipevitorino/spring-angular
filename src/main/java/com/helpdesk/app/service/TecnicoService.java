package com.helpdesk.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helpdesk.app.DTO.TecnicoDTO;
import com.helpdesk.app.entity.Pessoa;
import com.helpdesk.app.entity.Tecnico;
import com.helpdesk.app.exceptions.DataIntegrityViolationException;
import com.helpdesk.app.exceptions.ObjectNotFoundException;
import com.helpdesk.app.repositories.PessoaRepository;
import com.helpdesk.app.repositories.TecnicoRepository;

import jakarta.validation.Valid;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder enconder;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDto) {
		objDto.setId(null);
		objDto.setSenha(enconder.encode(objDto.getSenha()));
		validaEmailECpf(objDto);
		Tecnico newObj = new Tecnico(objDto);
		return repository.save(newObj);
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaEmailECpf(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Não é possivel deletar o técnico com ordens de serviços vinculadas!");
		}
		
		repository.deleteById(id);
		
	}

	private void validaEmailECpf(TecnicoDTO objDto) {
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
