package com.SafteyManagementSystem.project.ServiceImplementations;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SafteyManagementSystem.project.DAO.InjuryRepository;
import com.SafteyManagementSystem.project.Exceptions.CannotsaveException;
import com.SafteyManagementSystem.project.Exceptions.IdnotFoundException;
import com.SafteyManagementSystem.project.Exceptions.ValuesNotPresent;
import com.SafteyManagementSystem.project.Models.InjuryCentre;
import com.SafteyManagementSystem.project.Services.InjuryCentreServices;

@Service
public class InjuryServiceImplementation implements InjuryCentreServices{
	@Autowired InjuryRepository repo;
	
	
	public InjuryCentre getingdetailsbyId(Integer Id){
		Optional<InjuryCentre> list = repo.findById(Id);
		if(list.isPresent())
		{
			return list.get();
		}
		else
		{
			throw new IdnotFoundException("The id "+Id+" you are using is not present in our database");
		}
	}
	
	public List<InjuryCentre> getingAlldetails(){
		
		if(repo.findAll()==null) {
			throw new ValuesNotPresent("There is no data in the injury centre");
			
		}
		return repo.findAll();
	}
	
	public List<InjuryCentre> edittingDetails(InjuryCentre i, Integer Id){
		Optional<InjuryCentre> list = repo.findById(Id);
		if(list.isPresent())
		{
			i.setEmployeeid(Id);
			repo.save(i);
			return repo.findAll();
		}
		else
		{
			throw new IdnotFoundException("The Id "+Id+" you are trying to update is not present in our database");
		}
		
	}
	public void addNewEntry(InjuryCentre i){
		Optional<InjuryCentre> list = repo.findById(i.getInjuryid());
		if(list.isPresent())
		{
			throw new CannotsaveException("Id already present");
		}
		repo.save(i);
	}
	
	public Integer Ltiinfo(Integer id) {
		Optional<InjuryCentre> list = repo.findById(id);
		if(list.isPresent())
		{
			return list.get().getLtiinfo();
		}
		else
		{
			throw new IdnotFoundException("Id is not present to update");
		}
	}
	
}
