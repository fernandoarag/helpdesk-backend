package com.fernando.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fernando.helpdesk.domain.Cliente;
import com.fernando.helpdesk.domain.Pessoa;
import com.fernando.helpdesk.domain.dtos.ClienteDTO;
import com.fernando.helpdesk.repositories.ClienteRepository;
import com.fernando.helpdesk.repositories.PessoaRepository;
import com.fernando.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.fernando.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Cliente findById(Integer id) {
		Optional<Cliente> objCliente = clienteRepository.findById(id);
		return objCliente.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return clienteRepository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException(
					"O Cliente possui ordens de serviço vinculadas e não pode ser deletado!");
		}
		clienteRepository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
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
