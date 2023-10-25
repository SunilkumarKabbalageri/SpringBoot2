package com.demo4.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo4.springboot.model.EmpModel;
import com.demo4.springboot.service.EmpService;

@RestController // it is the combination of both @ResponceBody as well as @Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	// @RequestMapping(value="/empdetail",method =RequestMethod.POST) or else use
	// Insert the Single data into database
	@PostMapping("/empdetails")
	public EmpModel Empdetails(@RequestBody EmpModel empModel) {
		return empService.empCreate(empModel);
	}

	// insert the multiple data at the same time
	@PostMapping("/empdetailsall")
	public Iterable<EmpModel> addAllDetail(@RequestBody List<EmpModel> empModels) {
		Iterable<EmpModel> iterable = empService.addAll(empModels);
		return iterable;

	}

	// fetch the All the data at the same time
	@GetMapping("/empdetails")
	public Iterable<EmpModel> getData() {
		return empService.fetchAll();
	}

	// fetch the data by their id
	@GetMapping("/empdetails/{empid}")
	public Optional<EmpModel> fetchSingleData(@PathVariable("empid") int id) {
		return empService.getData(id);
	}

	// update the data by their ID
	@PutMapping("/empdetails/{empid}")
	public EmpModel updateData(@RequestBody EmpModel empModel, @PathVariable("empid") int id) {
		return empService.UpdateData(empModel, id);
		// for updating the tata 1st get then set and save at last
	}

	// delete the data by their ID
	@DeleteMapping("/empdetails/{empid}")
	public String DeletebyId(@PathVariable("empid") int id) {
		empService.deleteSingleData(id);
		return "Done";
	}

	// deleteAll the data from database
	@DeleteMapping("/empdetails")
	public String Deleteall() {
		empService.DeleteallData();
		return "Deleted all the data";
	}
	
  @GetMapping("/empdata/{ch}")
  public List<EmpModel> findByCharacter(@Param("ch") char ch) {
	 return empService.fetchByChar(ch);
  }
}
