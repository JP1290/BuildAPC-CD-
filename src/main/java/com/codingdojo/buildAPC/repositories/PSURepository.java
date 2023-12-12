package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.PSU;

@Repository
public interface PSURepository extends CrudRepository<PSU, Long> {
	
	Optional<PSU>findById(Long id);
	
	List<PSU>findAll();

}
