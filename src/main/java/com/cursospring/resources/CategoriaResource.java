package com.cursospring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
		
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		List<Categoria> listCategorias = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
		
		listCategorias.add(cat1);
		listCategorias.add(cat2);
		
		return listCategorias;
	}
}
