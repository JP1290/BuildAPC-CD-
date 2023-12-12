package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.CPU;
import com.codingdojo.buildAPC.repositories.CPURepository;

@Service
public class CPUService {

	@Autowired
	private CPURepository cpuRepo;
	
	public CPU findById(Long id) {
		
		Optional<CPU> cpuId = cpuRepo.findById(id);
		
		if(cpuId.isPresent()) {
			return cpuId.get();
		}
		
		return null;
	}
	
	public List<CPU> getAll() {
		return cpuRepo.findAll();
	}
}
