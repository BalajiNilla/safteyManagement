package com.SafteyManagementSystem.project.ServiceImplementations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SafteyManagementSystem.project.DAO.IncidentCentreRepository;
import com.SafteyManagementSystem.project.Exceptions.CannotsaveException;
import com.SafteyManagementSystem.project.Exceptions.IdnotFoundException;
import com.SafteyManagementSystem.project.Exceptions.ValuesNotPresent;
import com.SafteyManagementSystem.project.Models.IncidentCentre;
import com.SafteyManagementSystem.project.Services.IncidentCentreServices;
@Service
public class IncidentCentreServiceImp implements IncidentCentreServices {
	@Autowired IncidentCentreRepository repo;
	
    public IncidentCentre getSingleIncident(Integer id) {
    	Optional<IncidentCentre> list = repo.findById(id);
		if(list.isPresent())
		{
			return list.get();
		}
		else
		{
			throw new IdnotFoundException("The id "+id+" you are looking for is not present in the data base");
		}
    }
    public void newIncident( IncidentCentre ic) {
    	Optional<IncidentCentre> list =repo.findById(ic.getIncidentid());
    	if(!(list.isPresent())){
    		repo.save(ic);
    }
    	else 
    		throw new CannotsaveException("The details you are saving with id "+list.get().getIncidentid()+" are present" );
    }
    
    
    public List<IncidentCentre> getAllIncidents() {
    	List<IncidentCentre> list = repo.findAll();
    	if(list.isEmpty()) {
			throw new ValuesNotPresent("There is no data in the incident centre");
		}
    	return repo.findAll();
   	 
    }
    
    
    public void updateById(IncidentCentre ic, Integer id) {
    	Optional<IncidentCentre> list = repo.findById(id);
		if(list.isPresent())
		{
			ic.setIncidentid(id);
	    	repo.save(ic);
		}
		else
		{
			throw new IdnotFoundException("The id "+id + "is not present in the database");
		}
		
		
			
		}
    public void deletew(Integer Id) {
    	repo.deleteById(Id);
    	
   	 
    }

   
    
    
    
    
}
