package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.ComputerCase;
import com.codingdojo.buildAPC.repositories.ComputerCaseRepository;

@Service
public class ComputerCaseService {

	@Autowired
	private ComputerCaseRepository compCaseRepo;
	
	public ComputerCase findById(Long id) {
		
		Optional<ComputerCase> compCaseId = compCaseRepo.findById(id);
		
		if(compCaseId.isPresent()) {
			return compCaseId.get();
		}
		
		return null;
	}
	
	public List<ComputerCase> getAll() {
		return compCaseRepo.findAll();
	}
}
