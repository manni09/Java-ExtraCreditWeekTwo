package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	@Query("from Task t where t.project.id = :id")
    List<Task> findAllByProject(@Param("id") String id);
	
	@Query("from Task t where t.resource = :resource")
    List<Task> findAllTaskBySkill(@Param("resource") String resource);
	
}
