package com.fernando.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
