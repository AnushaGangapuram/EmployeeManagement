package com.iguroo.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iguroo.ems.dto.EmployeeDTO;
import com.iguroo.ems.service.EmployService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Employees")

public class EmployController {
	
	@Autowired 
	EmployService empservice;
	
	// add employee
	@PostMapping
	public ResponseEntity<EmployeeDTO> postMethodName(@RequestBody EmployeeDTO employeedto) {
		EmployeeDTO employeesdto= empservice.addEmp(employeedto);
		return new ResponseEntity<>(employeesdto, HttpStatus.CREATED);
	}
	
	// get employee 
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDTO>> getMethodName(){
		List<EmployeeDTO> employeesdto= empservice.getAll();
		return ResponseEntity.ok(employeesdto);			
	}
	
	// get employee by id 
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id){
		EmployeeDTO employeedto = empservice.getEmp(id);
		return ResponseEntity.ok(employeedto);	
	}
	// update employee
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id ,@RequestBody EmployeeDTO updateemployeedto){
		EmployeeDTO employeedto= empservice.updateEmp(id, updateemployeedto);
		return ResponseEntity.ok(employeedto);	
	}
	
	// delete employee
	@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        empservice.deleteEmp(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    
	}
}
