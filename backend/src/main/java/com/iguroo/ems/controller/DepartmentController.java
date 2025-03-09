package com.iguroo.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iguroo.ems.dto.DepartmentDTO;
import com.iguroo.ems.service.DepartmentService;
@RestController
@RequestMapping("/apis/department")

public class DepartmentController {
	@Autowired
	DepartmentService departService;

	@PostMapping
	public ResponseEntity<DepartmentDTO> postMethod(@RequestBody DepartmentDTO departmentdto) {
		DepartmentDTO department = departService.postDept(departmentdto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);

	}

	// get employee
	@GetMapping("/getAll")
	public ResponseEntity<List<DepartmentDTO>> getMethodName() {
		List<DepartmentDTO> deptdto = departService.getAll();
		return ResponseEntity.ok(deptdto);
	}

	// get employee by id

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDTO> getById(@PathVariable Long id) {
		DepartmentDTO deptdto = departService.getDept(id);
		return ResponseEntity.ok(deptdto);
	}

	// update employee
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDTO> update(@PathVariable Long id, @RequestBody DepartmentDTO updatedeptdto) {
		DepartmentDTO deptdto = departService.updateDept(id, updatedeptdto);
		return ResponseEntity.ok(deptdto);
	}

	// delete employee
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		departService.deleteDep(id);
		return ResponseEntity.ok("Employee deleted successfully!.");

	}

}
