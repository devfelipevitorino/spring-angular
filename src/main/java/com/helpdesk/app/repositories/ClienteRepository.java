package com.helpdesk.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
