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
@Table(name="InjuryTable")
public class InjuryCentre {
	@Id
	@Column(name="Injury_id")
	private Integer injuryid;
	
	@Column(name="Employee_id")
	@NonNull
	private Integer employeeid;
	
	
	@Column(name="Employee_name")
	@NonNull
	private String employyename;
	
	@Column(name="LTIDays")
	@NonNull
	private Integer ltiinfo;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_incidentId")
	private IncidentCentre incidentcentre;


	public InjuryCentre(Integer injuryid, Integer employeeid, String employyename, Integer ltiinfo,
			IncidentCentre incidentcentre) {
		super();
		this.injuryid = injuryid;
		this.employeeid = employeeid;
		this.employyename = employyename;
		this.ltiinfo = ltiinfo;
		this.incidentcentre = incidentcentre;
	}


	public InjuryCentre() {
		super();
	}


	public Integer getInjuryid() {
		return injuryid;
	}


	public void setInjuryid(Integer injuryid) {
		this.injuryid = injuryid;
	}


	public Integer getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}


	public String getEmployyename() {
		return employyename;
	}


	public void setEmployyename(String employyename) {
		this.employyename = employyename;
	}


	public Integer getLtiinfo() {
		return ltiinfo;
	}


	public void setLtiinfo(Integer ltiinfo) {
		this.ltiinfo = ltiinfo;
	}


	public IncidentCentre getIncidentcentre() {
		return incidentcentre;
	}


	public void setIncidentcentre(IncidentCentre incidentcentre) {
		this.incidentcentre = incidentcentre;
	}


	@Override
	public String toString() {
		return "InjuryCentre [injuryid=" + injuryid + ", employeeid=" + employeeid + ", employyename=" + employyename
				+ ", ltiinfo=" + ltiinfo +  "]";
	}

	
	
}