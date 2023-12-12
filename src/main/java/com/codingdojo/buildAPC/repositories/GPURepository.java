package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.GPU;

@Repository
public interface GPURepository extends CrudRepository<GPU, Long> {

	Optional<GPU>findById(Long id);
	
	List<GPU>findAll();
	
}
