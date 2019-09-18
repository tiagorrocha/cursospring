package com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
