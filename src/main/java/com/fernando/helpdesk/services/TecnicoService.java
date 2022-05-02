package com.fernando.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.helpdesk.domain.Pessoa;
import com.fernando.helpdesk.domain.Tecnico;
import com.fernando.helpdesk.domain.dtos.TecnicoDTO;
import com.fernando.helpdesk.repositories.PessoaRepository;
import com.fernando.helpdesk.repositories.TecnicoRepository;
import com.fernando.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.fernando.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> objTecnico = tecnicoRepository.findById(id);
		return objTecnico.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return tecnicoRepository.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return tecnicoRepository.save(oldObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> objPessoa = pessoaRepository.findByCpf(objDTO.getCpf());
		if (objPessoa.isPresent() && objPessoa.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		objPessoa = pessoaRepository.findByEmail(objDTO.getEmail());
		if (objPessoa.isPresent() && objPessoa.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}

}
