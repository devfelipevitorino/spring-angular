package com.helpdesk.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.app.entity.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
