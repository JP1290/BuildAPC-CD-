package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.GPU;
import com.codingdojo.buildAPC.repositories.GPURepository;

@Service
public class GPUService {

	
	@Autowired
	private GPURepository gpuRepo;
	
	public GPU findById(Long id) {
		
		Optional<GPU> gpuId = gpuRepo.findById(id);
		
		if(gpuId.isPresent()) {
			return gpuId.get();
		}
		
		return null;
	}
	
	public List<GPU> getAll() {
		return gpuRepo.findAll();
	}
}
