package com.fernando.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
