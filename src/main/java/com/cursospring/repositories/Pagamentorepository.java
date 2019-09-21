package com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.domain.Pagamento;

@Repository
public interface Pagamentorepository  extends JpaRepository<Pagamento, Integer>{
	
}
