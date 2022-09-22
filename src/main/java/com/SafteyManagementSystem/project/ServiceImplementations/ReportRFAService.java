package com.SafteyManagementSystem.project.ServiceImplementations;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.SafteyManagementSystem.project.DAO.RFArepository;
import com.SafteyManagementSystem.project.Models.RFA;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportRFAService {
	
	@Autowired
	private RFArepository repository;
	
	

	 public String exportRFAReport(String reportFormat) throws FileNotFoundException, JRException {
	        String path = "C:\\Users\\balaj\\Downloads";
	        List<RFA> employees = repository.findAll();
	        //load file and compile it
	        File file = ResourceUtils.getFile("classpath:RFA_report.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Java Techie");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (reportFormat.equalsIgnoreCase("html")) {
	            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\RFA.html");
	        }
	        if (reportFormat.equalsIgnoreCase("pdf")) {
	            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\RFA.pdf");
	        }

	        return "report generated in path : " + path;
	    }

}
