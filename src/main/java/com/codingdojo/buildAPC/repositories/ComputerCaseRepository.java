package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.ComputerCase;

@Repository
public interface ComputerCaseRepository extends CrudRepository<ComputerCase, Long> {

	Optional<ComputerCase>findById(Long id);
	
	List<ComputerCase>findAll();
	
}
