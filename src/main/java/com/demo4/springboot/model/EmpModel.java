package com.demo4.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "Employee_details") its ok if we didnt give also
public class EmpModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;
	private String emp_name;
	private String emp_mail;
	private long mob_no;
	private char grade;

	@OneToOne(cascade = CascadeType.ALL) // one to one mapping with company class
	@JsonManagedReference // it is applied on parent class
	// @JsonManagedReferences and JsonBackReferences are used to display objects
	// with parent child relationship.
	// @JsonManagedReferences is used to refer to parent object and
	// @JsonBackReferences is used to mark child objects.
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_mail() {
		return emp_mail;
	}

	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}

	public long getMob_no() {
		return mob_no;
	}

	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public EmpModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpModel(int emp_id, String emp_name, String emp_mail, long mob_no, char grade, Company company) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_mail = emp_mail;
		this.mob_no = mob_no;
		this.grade = grade;
		this.company = company;
	}

	@Override
	public String toString() {
		return "EmpModel [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_mail=" + emp_mail + ", mob_no=" + mob_no
				+ ", grade=" + grade + ", company=" + company + "]";
	}

}
