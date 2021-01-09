package com.sathya.ui.entity;

import java.util.List;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sathya.ui.dto.PlanDetailsDto;

public class RegisterBean {
	
	@NotNull
	private Long phoneNo;
	@NotEmpty
	private String name;
	@Size(min=8,max=20)
	private String password;
	@NotEmpty
	private String planId;
	private List<PlanDetailsDto> plansList;
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public List<PlanDetailsDto> getPlansList() {
		return plansList;
	}
	public void setPlansList(List<PlanDetailsDto> plansList) {
		this.plansList = plansList;
	}
	
	}
