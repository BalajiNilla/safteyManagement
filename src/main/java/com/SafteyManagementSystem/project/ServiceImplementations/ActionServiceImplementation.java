package com.SafteyManagementSystem.project.ServiceImplementations;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import com.SafteyManagementSystem.project.DAO.Actionrepository;
import com.SafteyManagementSystem.project.Exceptions.IdnotFoundException;
import com.SafteyManagementSystem.project.Models.RFA;
import com.SafteyManagementSystem.project.Services.ActionService;


@Service
public class ActionServiceImplementation implements ActionService {

	@Autowired Actionrepository repo;
	
	public String TrackStatus(Integer id) {
		Optional<RFA> list = repo.findById(id);
		if(list.isPresent())
		{
			Integer dtc = repo.findById(id).get().getDtc();
			
			String work = repo.findById(id).get().getWorkType();
			String res="";
			if(dtc<7 && dtc!=0) {
				res="Hi your work is "+work+" and you need to complete the work in "+dtc+" days";
			}
			else if(dtc==0) {
				res="good work you have completed your work";
			}
			else 
				res="Hi your work is "+work+" and you need to hand over the work  to superrior as "+dtc+" days completed";
			return res;
			
		}
		else
		{
			throw new IdnotFoundException("The id "+id+" you are using is not present in our database");
		}
	}		
		
		
	}
