package com.SafteyManagementSystem.project.Services;

import java.util.List;

import com.SafteyManagementSystem.project.Models.RFA;

public interface RFAService {

	public void addrecord(RFA newc);
	public RFA getDetailsById(Integer id);
	public List<RFA> getRecords();
	public void updation(RFA rfa,Integer id);
	public List<RFA> del(Integer id);
}
