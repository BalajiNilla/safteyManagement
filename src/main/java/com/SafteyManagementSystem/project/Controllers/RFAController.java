package com.SafteyManagementSystem.project.Controllers;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SafteyManagementSystem.project.Models.RFA;
import com.SafteyManagementSystem.project.ServiceImplementations.ReportRFAService;
import com.SafteyManagementSystem.project.Services.RFAService;

import net.sf.jasperreports.engine.JRException;
@RestController
@RequestMapping("api/rfa")
public class RFAController {
	@Autowired
	RFAService serv;
	
	@Autowired ReportRFAService reportservice;

	@PostMapping("user/adddetails")
	public void addRecord(@RequestBody RFA r) {
		
		
	serv.addrecord(r);
	}

	@GetMapping("user/details/{id}")

	public RFA getRFA(@PathVariable Integer id){
	
		return serv.getDetailsById(id);
	
}

	@PutMapping("user/editdetails/{id}")

	public void updaterecord(@RequestBody RFA r,@PathVariable Integer id) {
	serv.updation(r, id);
}

	@GetMapping("/user/setreports")

	public ResponseEntity<List<RFA>> allRecords() {
	
		List<RFA> list =new ArrayList<RFA>();
	
		list=serv.getRecords();
	
		return new ResponseEntity<>(list,HttpStatus.OK);
}
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format )throws FileNotFoundException, JRException{
		return reportservice.exportRFAReport(format);
		
	}


	@DeleteMapping("/authorized/delerfa/{id}")

	public List<RFA> del(@PathVariable Integer id){
	
		return serv.del(id);
}
}