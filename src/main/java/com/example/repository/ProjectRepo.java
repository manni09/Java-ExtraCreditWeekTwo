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
	
	@Query("from Project p where p.id =:id")
	Project findProjectById(@Param("id") String id);
	
	@Query("from Project p where p.name like CONCAT('%',:keyword,'%') ")
	List<Project> findAllProjectsByKeyword(@Param("keyword") String keyword);
	
	@Query("from Project p where p.description like CONCAT('%',:description,'%') ")
	List<Project> findAllByDescriptionLike(@Param("description") String description);
	
}
