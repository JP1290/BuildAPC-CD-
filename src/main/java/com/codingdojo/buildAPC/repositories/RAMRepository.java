package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.RAM;

@Repository
public interface RAMRepository extends CrudRepository<RAM, Long> {
	
	Optional<RAM>findById(Long id);
	
	List<RAM>findAll();

}
