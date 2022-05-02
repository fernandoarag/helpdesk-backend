package com.fernando.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
