package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.CPUCooler;

@Repository
public interface CPUCoolerRepository extends CrudRepository<CPUCooler, Long> {

	Optional<CPUCooler>findById(Long id);
	
	List<CPUCooler>findAll();
	
}
