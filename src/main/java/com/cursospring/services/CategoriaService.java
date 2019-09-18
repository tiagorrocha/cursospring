package com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.domain.Categoria;
import com.cursospring.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	public Optional<Categoria> buscar(Integer id) {
		return repository.findById(id);
	}
	public Iterable<Categoria> getAll(){
		return repository.findAll();
	}
	public Categoria create(Categoria cat) {
		return repository.save(cat);
	}
	public Optional<Categoria> delete(Integer id){
		Optional<Categoria> cat = repository.findById(id);
		if(cat != null) 
			repository.deleteById(id);
		return cat;	
	}
}
