package com.SafteyManagementSystem.project.Controllers;
import java.io.FileNotFoundException;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SafteyManagementSystem.project.Models.InjuryCentre;
import com.SafteyManagementSystem.project.ServiceImplementations.InjuryServiceImplementation;
import com.SafteyManagementSystem.project.ServiceImplementations.ReportInjuryService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("api/injurycentre")
public class InjuryCentreController {
	@Autowired InjuryServiceImplementation serv;
	@Autowired ReportInjuryService reportservice;

	
@GetMapping("/user/details/{id}")
public  InjuryCentre getDetailsbyId(@PathVariable Integer id) {
	return serv.getingdetailsbyId(id);
	}


@GetMapping("/user/setreports")
public ResponseEntity<List<InjuryCentre>> getAlldetails(){
	return new ResponseEntity<>(serv.getingAlldetails(), HttpStatus.OK);
}


@PutMapping("/user/editdetails/{id}")
public List<InjuryCentre> editingdetails(@RequestBody InjuryCentre i,@PathVariable Integer id){
	return serv.edittingDetails(i,id);	
}

@PostMapping("/user/adddetails")
public void NewEntry(@RequestBody InjuryCentre i){
	 serv.addNewEntry(i);
}
@GetMapping("/user/ltiinfo/{id}")
public Integer getLti(@PathVariable Integer id) {
	return serv.Ltiinfo(id);
}
@GetMapping("/report/{format}")
public String generateReport(@PathVariable String format )throws FileNotFoundException, JRException{
	return reportservice.exportInjuryReport(format);
	
}

}
