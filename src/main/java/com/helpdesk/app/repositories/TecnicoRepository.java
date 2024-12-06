package com.helpdesk.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.app.entity.Pessoa;

public interface TecnicoRepository extends JpaRepository<Pessoa, Integer>{

}
