package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Project;
import com.example.domain.Status;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
	List<Project> findByStatus(Status status);
}
