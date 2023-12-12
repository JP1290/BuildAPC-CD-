package com.codingdojo.buildAPC.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.buildAPC.models.Motherboard;

@Repository
public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {
	
	Optional<Motherboard>findById(Long id);
	
	List<Motherboard>findAll();

}
