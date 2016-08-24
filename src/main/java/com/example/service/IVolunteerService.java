package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Address;
import com.example.domain.Project;
import com.example.domain.Status;

@Service
public interface IVolunteerService {
	void createProject(Project project);

	List<Project> getAll();

	List<Project> searchProjectByStatus(Status status);

	List<Project> getProjectByKeyword(String keyword);

	List<Project> getProjectByLocation(Address addr);
}
