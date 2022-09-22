package com.SafteyManagementSystem.project.ServiceImplementations;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SafteyManagementSystem.project.DAO.RFArepository;
import com.SafteyManagementSystem.project.Exceptions.CannotsaveException;
import com.SafteyManagementSystem.project.Exceptions.IdnotFoundException;
import com.SafteyManagementSystem.project.Exceptions.ValuesNotPresent;

import com.SafteyManagementSystem.project.Models.RFA;
import com.SafteyManagementSystem.project.Services.RFAService;
@Service
public class RFAServiceImplementation implements RFAService{
	@Autowired
	RFArepository repo;
	
	
	public void addrecord(RFA newc) {
		Optional<RFA> list = repo.findById(newc.getRfaid());
		if(list.isPresent())
		{
			throw new CannotsaveException("The id "+newc.getRfaid()+" details are already present in the database");
			
		}
			
		repo.save(newc);
	}
	
	public RFA getDetailsById(Integer id) {
		Optional<RFA> list = repo.findById(id);
		if(!(list.isPresent()))
			throw new IdnotFoundException(" the id "+id+" is not present in the database ");
			
		return repo.findById(id).get();
	}
	
	public List<RFA> getRecords(){
		List<RFA> list = new ArrayList<RFA>();
		if(repo.findAll()==null) {
			throw new ValuesNotPresent("There is no data in the RFA Table");
			
		}
		repo.findAll().forEach(list::add);
		return list;
	}
	public void updation(RFA rfa,Integer id) {
		Optional<RFA> list = repo.findById(id);
		if(!(list.isPresent()))
			throw new CannotsaveException("The id "+id+" details are not present in the database");
		rfa.setRfaid(id);
		repo.save(rfa);
	}
	public List<RFA> del(Integer id)
	{
		Optional<RFA> list = repo.findById(id);
		if(!(list.isPresent()))
			throw new IdnotFoundException(" the id "+id+" is not present in the database ");
		repo.deleteById(id);
		return repo.findAll();

	}

}