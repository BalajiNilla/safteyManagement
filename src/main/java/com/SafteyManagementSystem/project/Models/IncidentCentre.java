package com.SafteyManagementSystem.project.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;
@Entity
@Table(name="incidentTable")
public class IncidentCentre{
	@Id
	@Column(name="IncidentId")
	private Integer incidentid;
	
	@Column(name="incidentdate")
	@NonNull
	private String incidentDate;
	
	@Column(name="HosReq")
	@NonNull
	private String hosreq;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_rfaid")
	private RFA rfa;


	public Integer getIncidentid() {
		return incidentid;
	}


	public void setIncidentid(Integer incidentid) {
		this.incidentid = incidentid;
	}


	public String getIncidentDate() {
		return incidentDate;
	}


	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}


	public String getHosreq() {
		return hosreq;
	}


	public void setHosreq(String hosreq) {
		this.hosreq = hosreq;
	}


	public RFA getRfa() {
		return rfa;
	}


	public void setRfa(RFA rfa) {
		this.rfa = rfa;
	}


	public IncidentCentre(Integer incidentid, String incidentDate, String hosreq,
			RFA rfa) {
		super();
		this.incidentid = incidentid;
		this.incidentDate = incidentDate;
		this.hosreq = hosreq;
		this.rfa = rfa;
	}


	public IncidentCentre() {
		super();
	}


	@Override
	public String toString() {
		return "IncidentCentre [incidentid=" + incidentid + ", incidentDate=" + incidentDate + ", hosreq=" + hosreq
				 + ", rfa=" + rfa + "]";
	}
	
	
	
	
	
	
}