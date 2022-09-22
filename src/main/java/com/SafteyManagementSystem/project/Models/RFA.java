package com.SafteyManagementSystem.project.Models;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="RFATable")
public class RFA {
	@Id
	@GeneratedValue
	@Column(name="RFA_Id")
	private Integer rfaid;
	
	
	@Column(name="WorkType")
	@NonNull
	private String WorkType;
	
	
	@Column(name="Dtc")
	@NonNull
	private Integer dtc;
	
	@Column(name="personalName")
	@NonNull
	private String pName;

	public RFA(Integer rfaid, String workType, Integer dtc, String pName) {
		super();
		this.rfaid = rfaid;
		WorkType = workType;
		this.dtc = dtc;
		this.pName = pName;
	}

	public RFA() {
		super();
	}

	public Integer getRfaid() {
		return rfaid;
	}

	public void setRfaid(Integer rfaid) {
		this.rfaid = rfaid;
	}

	public String getWorkType() {
		return WorkType;
	}

	public void setWorkType(String workType) {
		WorkType = workType;
	}

	public Integer getDtc() {
		return dtc;
	}

	public void setDtc(Integer dtc) {
		this.dtc = dtc;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "RFA [rfaid=" + rfaid + ", WorkType=" + WorkType + ", dtc=" + dtc + ", pName=" + pName + "]";
	}
}