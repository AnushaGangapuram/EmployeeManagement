package com.iguroo.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iguroo.ems.dto.EmployeeDTO;

@Service

public interface EmployService {
	
	EmployeeDTO addEmp(EmployeeDTO employeedto);

	List<EmployeeDTO> getAll();

	EmployeeDTO getEmp(Long id);

	EmployeeDTO updateEmp(Long id, EmployeeDTO updateemployeedto);

	void  deleteEmp(Long id);

}
