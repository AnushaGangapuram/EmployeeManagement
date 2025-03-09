package com.iguroo.ems.mapper;

import com.iguroo.ems.dto.DepartmentDTO;
import com.iguroo.ems.entity.Department;


public class DepartmentMapper {
	 public static DepartmentDTO mapToDepartmentDto(Department department){
	        return new DepartmentDTO(
	                department.getId(),
	                department.getDepartmentName(),
	                department.getDepartmentDescription()
	        );
	    }

	    // convert department dto into department jpa entity
	    public static Department mapToDepartment(DepartmentDTO departmentDto){
	        return new Department(
	                departmentDto.getId(),
	                departmentDto.getDepartmentName(),
	                departmentDto.getDepartmentDescription()
	        );
	    }

}
