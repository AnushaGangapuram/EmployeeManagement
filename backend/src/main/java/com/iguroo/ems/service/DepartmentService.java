package com.iguroo.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iguroo.ems.dto.DepartmentDTO;

@Service
public interface DepartmentService {

	DepartmentDTO postDept(DepartmentDTO departmentdto);

	List<DepartmentDTO> getAll();

	DepartmentDTO getDept(Long id);

	DepartmentDTO updateDept(Long id, DepartmentDTO updatedeptdto);

	void deleteDep(Long id);

	



}
