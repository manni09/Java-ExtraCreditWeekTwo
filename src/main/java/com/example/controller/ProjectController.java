package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Project;
import com.example.service.IVolunteerService;

@Controller
@RequestMapping("/admin")
public class ProjectController {
	@Autowired
	IVolunteerService volunteerService;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String projectList(){
        return "admin";
    }
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getAllProjects(Model model){
		List<Project> projectList = volunteerService.getAll();
        model.addAttribute("projectList", projectList);
        return "projects";
    }
	
	@RequestMapping(value = "/project/add", method = RequestMethod.GET)
	public String addProject(Model model){
		
		return "addproject";
	}
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProjectFormProcess(Project project){
        
        return "redirect:/projects";
    }
    
}
