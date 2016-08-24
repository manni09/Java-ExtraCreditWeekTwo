package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Address;
import com.example.domain.Project;
import com.example.domain.Status;
import com.example.repository.ProjectRepo;


@Component
public class VolunteerService implements IVolunteerService {

	@Autowired
    ProjectRepo projectRepo;
	
	@Override
	public void createProject(Project project) {
		// TODO Auto-generated method stub
		projectRepo.save(project);
	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public List<Project> searchProjectByStatus(Status status) {
		// TODO Auto-generated method stub
		return projectRepo.findByStatus(status);
	}

	@Override
	public List<Project> getProjectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjectByLocation(Address addr) {
		// TODO Auto-generated method stub
		return null;
	}

}
