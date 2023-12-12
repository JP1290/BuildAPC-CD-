package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.CPUCooler;
import com.codingdojo.buildAPC.repositories.CPUCoolerRepository;

@Service
public class CPUCoolerService {

	@Autowired
	private CPUCoolerRepository coolRepo;
	
	public CPUCooler findById(Long id) {
		
		Optional<CPUCooler> coolerId = coolRepo.findById(id);
		
		if(coolerId.isPresent()) {
			return coolerId.get();
		}
		return null;
	}
	
	public List<CPUCooler> getAll() {
		return coolRepo.findAll();
	}
}
