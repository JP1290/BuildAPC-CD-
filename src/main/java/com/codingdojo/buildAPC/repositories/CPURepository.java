package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.CPU;

@Repository
public interface CPURepository extends CrudRepository<CPU, Long> {

	Optional<CPU>findById(Long id);
	
	List<CPU>findAll();
	
}
