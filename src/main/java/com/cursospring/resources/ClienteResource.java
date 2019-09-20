package com.cursospring.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.domain.Cliente;
import com.cursospring.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
		
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente cli = service.buscar(id);
		return ResponseEntity.ok().body(cli);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Cliente> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Cliente create(@RequestBody Cliente cli) {
		return service.create(cli);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public Optional<Cliente> delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
