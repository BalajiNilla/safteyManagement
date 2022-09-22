package com.SafteyManagementSystem.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SafteyManagementSystem.project.Models.RFA;



public interface Actionrepository extends JpaRepository<RFA, Integer> {
	

}
