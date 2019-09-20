package com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.domain.Cliente;
import com.cursospring.repositories.ClienteRepository;
import com.cursospring.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> cat = repository.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + " Type: " + Cliente.class.getName()));
	}

	public Iterable<Cliente> getAll() {
		return repository.findAll();
	}

	public Cliente create(Cliente cat) {
		return repository.save(cat);
	}

	public Optional<Cliente> delete(Integer id) {
		Optional<Cliente> cat = repository.findById(id);
		if (cat != null)
			repository.deleteById(id);
		return cat;
	}
}
