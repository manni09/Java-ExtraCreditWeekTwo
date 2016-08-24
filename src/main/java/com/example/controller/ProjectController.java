package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Address;
import com.example.domain.Project;
import com.example.domain.Status;
import com.example.service.IVolunteerService;
import com.mysql.fabric.xmlrpc.base.Data;


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
		//addprojectNow();
		List<Project> projectList = volunteerService.getAll();
        model.addAttribute("projectList", projectList);
        return "projects";
    }
	
	@RequestMapping(value = "/project/add", method = RequestMethod.GET)
	public String addProject(Model model){
		Status[] status = Status.values();
		model.addAttribute("status", status);
		return "addproject";
	}
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProjectFormProcess(Project project){
        // Un-implimeneted 
        return "redirect:/projects";
    }
    
	private void addprojectNow(){
		Project project = new Project();
		project.setName("Green Area");
		project.setDescription("Plant a tree and change the world");
		project.setStatus(Status.INPROCESS);
		project.setEnd_date(new Date());
		project.setStart_date(new Date());
		
		Address add = new Address();
		add.setStreet("1000 North 4th St.");
		add.setCity("Fairfield");
		add.setState("Iowa");
		add.setZip("52557");
		project.setAddress(new Address());
		
		volunteerService.createProject(project);
	}
}
