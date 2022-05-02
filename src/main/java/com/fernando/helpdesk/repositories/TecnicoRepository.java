package com.fernando.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
