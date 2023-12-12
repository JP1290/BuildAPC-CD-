package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.PSU;
import com.codingdojo.buildAPC.repositories.PSURepository;

@Service
public class PSUService {

	
	@Autowired
	private PSURepository psuRepo;
	
	public PSU findById(Long id) {
		
		Optional<PSU> psuId = psuRepo.findById(id);
		
		if(psuId.isPresent()) {
			return psuId.get();
		}
		
		return null;
	}
	
	public List<PSU> getAll() {
		return psuRepo.findAll();
	}
}
