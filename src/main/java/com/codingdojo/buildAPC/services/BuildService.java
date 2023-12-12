package com.codingdojo.buildAPC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.buildAPC.models.Build;
import com.codingdojo.buildAPC.repositories.BuildRepository;

@Service
public class BuildService {

	@Autowired
	private BuildRepository repo;
	
	public Build findById(Long id) {
		
		Optional<Build> builds = repo.findById(id);
		
		if(builds.isPresent()) {
			return builds.get();
		}
		
		return null;
	}
	
	public List<Build> getAll() {
		return repo.findAll();
	}
	
	public Build create(Build build) {
		return repo.save(build);
	}
	
	public void delete(Build build) {
		repo.delete(build);
	}
	
}
