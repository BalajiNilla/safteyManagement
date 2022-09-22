package com.SafteyManagementSystem.project.Controllers;
import java.io.FileNotFoundException;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SafteyManagementSystem.project.Models.IncidentCentre;
import com.SafteyManagementSystem.project.ServiceImplementations.IncidentCentreServiceImp;
import com.SafteyManagementSystem.project.ServiceImplementations.ReportIncidentService;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("api/incidentcentre")
public class IncidentCentreController {
	@Autowired IncidentCentreServiceImp serv;
	@Autowired ReportIncidentService reportservice;
		@PostMapping("user/adddetails")
		public void addIncident(@RequestBody IncidentCentre ic) {
			serv.newIncident(ic);
		}
		@GetMapping("user/details/{id}")
		public IncidentCentre getIncidentDetails(@PathVariable Integer id){
			return serv.getSingleIncident(id);
			
		}
		@PutMapping("user/editdetails/{id}")
		public void updateIncident(@RequestBody IncidentCentre ic,@PathVariable Integer id) {
			serv.updateById(ic, id);
			
		}
		@GetMapping("/user/setreports")
		public List<IncidentCentre> allIncidentRecords() {
			 
			 return serv.getAllIncidents();
		}
		@GetMapping("/report/{format}")
		public String generateReport(@PathVariable String format )throws FileNotFoundException, JRException{
			return reportservice.exportIncidentReport(format);
			
}
}
