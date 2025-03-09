package com.iguroo.ems.service.implnt;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iguroo.ems.dto.EmployeeDTO;
import com.iguroo.ems.entity.Employee;
import com.iguroo.ems.exception.ResourceNotFoundException;
import com.iguroo.ems.mapper.EmployMapper;
import com.iguroo.ems.repository.EmployRespository;
import com.iguroo.ems.service.EmployService;

@Service

public class EmployImplnt implements EmployService{
	
	@Autowired 
	EmployRespository emprepo;
	
	//Add Employee
	@Override
	public EmployeeDTO addEmp(EmployeeDTO employeedto) {
		Employee employee = EmployMapper.mapToEntity(employeedto);
		Employee savedEmp= emprepo.save(employee);
		return EmployMapper.mapToDto(savedEmp);
	}
	//get employees
	@Override
	public List<EmployeeDTO> getAll() {
		List<Employee> employees= emprepo.findAll();
		return employees.stream().map((Employee)->EmployMapper.mapToDto(Employee))
				.collect(Collectors.toList());
	}
	// get emp by id
	@Override
	public EmployeeDTO getEmp(Long id) {
		  Employee employee = emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " + id));
	        return EmployMapper.mapToDto(employee);
	}
	@Override
	public EmployeeDTO updateEmp(Long id, EmployeeDTO updateemployeedto) {
		Employee employee= emprepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee is not exist by given id"+ id));
		
		employee.setFirstName(updateemployeedto.getFirstName());
		employee.setLastName(updateemployeedto.getLastName());
		employee.setEmail(updateemployeedto.getEmail());
		employee.setDesig(updateemployeedto.getDesig());
		
		Employee updatedEmp = emprepo.save(employee); // Ensure changes are saved in DB
		return EmployMapper.mapToDto(updatedEmp);
	}
	@Override
	public void deleteEmp(Long id) {
		Employee employee = emprepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + id)
        );

        emprepo.deleteById(id);
		
	}
	

}
