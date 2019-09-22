package com.cursospring.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.domain.Pedido;
import com.cursospring.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
		
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido ped = service.buscar(id);
		return ResponseEntity.ok().body(ped);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Pedido> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Pedido create(@RequestBody Pedido ped) {
		return service.create(ped);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public Optional<Pedido> delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
