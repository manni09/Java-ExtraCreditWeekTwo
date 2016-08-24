package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Project;
import com.example.service.IVolunteerService;

@Controller
public class TaskController {
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	@ResponseBody
	public String projectList(){
        return "Welcome to Volunteery Service";
    }
    
}
