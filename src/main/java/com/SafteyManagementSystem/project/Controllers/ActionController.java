package com.SafteyManagementSystem.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SafteyManagementSystem.project.ServiceImplementations.ActionServiceImplementation;
@RestController
@RequestMapping("/api/action")
public class ActionController {
	
	@Autowired ActionServiceImplementation serv;
	
	@GetMapping("/viewstatus/{id}")
	public String stat(@PathVariable Integer id) {
		return serv.TrackStatus(id);
	}

}
