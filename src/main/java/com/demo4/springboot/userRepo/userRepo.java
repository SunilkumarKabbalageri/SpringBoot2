package com.demo4.springboot.userRepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo4.springboot.model.EmpModel;

public interface userRepo extends CrudRepository<EmpModel, Integer> {
	public List<EmpModel> findByGradeStartingWith(char c);

}
