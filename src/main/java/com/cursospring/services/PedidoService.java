package com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.domain.Pedido;
import com.cursospring.repositories.PedidoRepository;
import com.cursospring.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> ped = repository.findById(id);
		return ped.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + " Type: " + Pedido.class.getName()));
	}

	public Iterable<Pedido> getAll() {
		return repository.findAll();
	}

	public Pedido create(Pedido ped) {
		return repository.save(ped);
	}

	public Optional<Pedido> delete(Integer id) {
		Optional<Pedido> ped = repository.findById(id);
		if (ped != null)
			repository.deleteById(id);
		return ped;
	}
}
