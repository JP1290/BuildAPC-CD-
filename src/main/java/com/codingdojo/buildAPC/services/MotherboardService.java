package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.Motherboard;
import com.codingdojo.buildAPC.repositories.MotherboardRepository;

@Service
public class MotherboardService {

	@Autowired
	private MotherboardRepository moboRepo;
	
	public Motherboard findById(Long id) {
		
		Optional<Motherboard> moboId = moboRepo.findById(id);
		
		if(moboId.isPresent()) {
			return moboId.get();
		}
		
		return null;
	}
	
	public List<Motherboard> getAll() {
		return moboRepo.findAll();
	}
}
