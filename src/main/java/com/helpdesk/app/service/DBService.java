package com.helpdesk.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.app.entity.Chamado;
import com.helpdesk.app.entity.Cliente;
import com.helpdesk.app.entity.Tecnico;
import com.helpdesk.app.enums.Perfil;
import com.helpdesk.app.enums.Prioridade;
import com.helpdesk.app.enums.Status;
import com.helpdesk.app.repositories.ChamadoRepository;
import com.helpdesk.app.repositories.ClienteRepository;
import com.helpdesk.app.repositories.TecnicoRepository;

@Service
public class DBService {
	
	 	@Autowired
	    private TecnicoRepository tecnicoRepository;
	    
	    @Autowired
	    private ClienteRepository clienteRepository;
	    
	    @Autowired
	    private ChamadoRepository chamadoRepository;

	    public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Felipe", "130.177.274-75", "felipe@email.com", "123");
        tec1.addPerfil(Perfil.TECNICO);
        
        Cliente cli1 = new Cliente(null, "Linus Torvalds", "027.449.190-71", "torvalds@email.com", "123");
        
        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        
        tecnicoRepository.saveAll(Arrays.asList(tec1)); 
        clienteRepository.saveAll(Arrays.asList(cli1));  
        chamadoRepository.saveAll(Arrays.asList(c1)); 
	}
	
}
