package com.SafteyManagementSystem.project.ServiceImplementations;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.SafteyManagementSystem.project.DAO.InjuryRepository;
import com.SafteyManagementSystem.project.Models.InjuryCentre;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportInjuryService {
	 @Autowired
	    private InjuryRepository repository;


	    public String exportInjuryReport(String reportFormat) throws FileNotFoundException, JRException {
	        String path = "C:\\Users\\balaj\\Downloads";
	        List<InjuryCentre> employees = repository.findAll();
	        //load file and compile it
	        File file = ResourceUtils.getFile("classpath:injury_centre.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Java Techie");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (reportFormat.equalsIgnoreCase("html")) {
	            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\injurycentre.html");
	        }
	        if (reportFormat.equalsIgnoreCase("pdf")) {
	            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\injurycentre.pdf");
	        }

	        return "report generated in path : " + path;
	    }

}
