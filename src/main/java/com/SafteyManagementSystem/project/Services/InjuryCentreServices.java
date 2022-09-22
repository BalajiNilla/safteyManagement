package com.SafteyManagementSystem.project.Services;

import java.util.List;

import com.SafteyManagementSystem.project.Models.InjuryCentre;

public interface InjuryCentreServices {
	public InjuryCentre getingdetailsbyId(Integer Id);
	
	public List<InjuryCentre> getingAlldetails();
	
	public void addNewEntry(InjuryCentre i);
	
	public Integer Ltiinfo(Integer id);
	

}
