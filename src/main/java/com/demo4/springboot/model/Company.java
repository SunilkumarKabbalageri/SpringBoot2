package com.demo4.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int company_Id;
	private String company_name;
	private String company_code;
	private String location;

	@OneToOne(mappedBy = "company")// we used mapped by to pointout or to make forien key
	@JsonBackReference //it will ignore the child data
	private EmpModel empmodel;


	public EmpModel getEmpmodel() {
		return empmodel;
	}

	public void setEmpmodel(EmpModel empmodel) {
		this.empmodel = empmodel;
	}

	public int getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(int company_Id) {
		this.company_Id = company_Id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company(int company_Id, String company_name, String company_code, String location) {
		super();
		this.company_Id = company_Id;
		this.company_name = company_name;
		this.company_code = company_code;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [company_Id=" + company_Id + ", company_name=" + company_name + ", company_code=" + company_code
				+ ", location=" + location + "]";
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

}
