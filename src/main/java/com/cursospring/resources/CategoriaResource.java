package com.cursospring.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.domain.Categoria;
import com.cursospring.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
		
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Optional<Categoria> find(@PathVariable Integer id) {
		return service.buscar(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Categoria> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Categoria create(@RequestBody Categoria cat) {
		return service.create(cat);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public Optional<Categoria> delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
