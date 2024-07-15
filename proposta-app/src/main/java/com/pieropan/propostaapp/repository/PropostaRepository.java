package com.pieropan.propostaapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pieropan.propostaapp.entity.Proposta;

@Repository
public interface PropostaRepository  extends CrudRepository<Proposta, Long>{

	List<Proposta> findAllByIntegradaIsFalse(); // Query derivadas. Querys que implementamos de forma declarativa no método.
	// Obtemos assim todas as propostas que não foram integradas.
}
