package com.demo4.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;

import com.demo4.springboot.model.EmpModel;
import com.demo4.springboot.userRepo.userRepo;

@Component
public class EmpService {

	@Autowired
	private userRepo repo;

	public EmpModel empCreate(EmpModel empModel) {
		EmpModel empModel2 = repo.save(empModel);
		return empModel2;
	}

	public Iterable<EmpModel> addAll(List<EmpModel> empModels) {
		Iterable<EmpModel> iterable = repo.saveAll(empModels);
		iterable.forEach(e -> {
			System.out.println(e);
		});
		return iterable;
	}

	public Iterable<EmpModel> fetchAll() {

		return repo.findAll();
	}

	public Optional<EmpModel> getData(int id) {
		Optional<EmpModel> optional=repo.findById(id);
		return optional;
		
	}

	public EmpModel UpdateData(EmpModel empModel, int id) {
		
		Optional<EmpModel> optional=repo.findById(id);
		EmpModel empModel2=optional.get();
		empModel2.setEmp_name(empModel.getEmp_name());
		empModel2.setEmp_mail(empModel.getEmp_mail());
		empModel2.setMob_no(empModel.getMob_no());
		empModel2.setGrade(empModel.getGrade());
		
		return repo.save(empModel2);
	}

	public void deleteSingleData(int id) {
		repo.deleteById(id);
		//return ResponseEntity.status(HttpStatus.ACCEPTED);
	}

	public void DeleteallData() {
		repo.deleteAll();
		
	}

	public List<EmpModel> fetchByChar(char ch) {
		List<EmpModel> empModels=repo.findByGradeStartingWith(ch);
		return empModels;
		
	}

}
