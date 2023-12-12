package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.RAM;
import com.codingdojo.buildAPC.repositories.RAMRepository;

@Service
public class RAMService {

	@Autowired
	private RAMRepository ramRepo;
	
	public RAM findByid(Long id) {
		
		Optional<RAM> ramId = ramRepo.findById(id);
		
		if(ramId.isPresent()) {
			return ramId.get();
		}
		
		return null;
	}
	
	public List<RAM> getAll() {
		return ramRepo.findAll();
	}
}
