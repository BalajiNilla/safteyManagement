package com.SafteyManagementSystem.project.Services;

import java.util.List;

import com.SafteyManagementSystem.project.Models.IncidentCentre;

public interface IncidentCentreServices {

	  IncidentCentre getSingleIncident(Integer id);
	 void newIncident( IncidentCentre ic);
	 List<IncidentCentre> getAllIncidents();
	  void updateById(IncidentCentre ic, Integer id);
}
