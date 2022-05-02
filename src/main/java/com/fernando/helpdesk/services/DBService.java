package com.fernando.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.helpdesk.domain.Chamado;
import com.fernando.helpdesk.domain.Cliente;
import com.fernando.helpdesk.domain.Tecnico;
import com.fernando.helpdesk.domain.enums.Perfil;
import com.fernando.helpdesk.domain.enums.Prioridade;
import com.fernando.helpdesk.domain.enums.Status;
import com.fernando.helpdesk.repositories.ChamadoRepository;
import com.fernando.helpdesk.repositories.ClienteReposiroty;
import com.fernando.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteReposiroty clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Fernando Aragao", "16172773046", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "95872036078", "torvalds@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
