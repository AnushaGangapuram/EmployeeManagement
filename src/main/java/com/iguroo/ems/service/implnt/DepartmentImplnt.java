package com.iguroo.ems.service.implnt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iguroo.ems.dto.DepartmentDTO;
import com.iguroo.ems.entity.Department;
import com.iguroo.ems.exception.ResourceNotFoundException;
import com.iguroo.ems.mapper.DepartmentMapper;
import com.iguroo.ems.repository.DepartmentRepository;
import com.iguroo.ems.service.DepartmentService;

@Service

public class DepartmentImplnt implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepo;

	@Override
	public DepartmentDTO postDept(DepartmentDTO departmentdto) {
		Department dept = DepartmentMapper.mapToDepartment(departmentdto);
		Department saveddto = deptRepo.save(dept);
		return DepartmentMapper.mapToDepartmentDto(saveddto);
	}
	


	@Override
	public List<DepartmentDTO> getAll() {
		List<Department> departments = deptRepo.findAll();
		return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDTO getDept(Long id) {
		Department department = deptRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department is not exists with a given id: " + id));
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public DepartmentDTO updateDept(Long id, DepartmentDTO updatedeptdto) {
		Department department = deptRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department is not exists with a given id:" + id));

		department.setDepartmentName(updatedeptdto.getDepartmentName());
		department.setDepartmentDescription(updatedeptdto.getDepartmentDescription());

		Department savedDepartment = deptRepo.save(department);

		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public void deleteDep(Long id) {
		deptRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Department is not exists with a given id: " + id));

		deptRepo.deleteById(id);
	
	}

}
