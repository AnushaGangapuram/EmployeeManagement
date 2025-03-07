package com.iguroo.ems.mapper;

import com.iguroo.ems.dto.EmployeeDTO;
import com.iguroo.ems.entity.Employee;

public class EmployMapper {
	
	public static EmployeeDTO mapToDto(Employee employee) {
		return new  EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDesig()
				);
	}
	public static Employee mapToEntity(EmployeeDTO employeedto) {
		return new Employee(
				
				employeedto.getId(),
				employeedto.getFirstName(),
				employeedto.getLastName(),
				employeedto.getEmail(),
				employeedto.getDesig()
				);
		
	}

}
