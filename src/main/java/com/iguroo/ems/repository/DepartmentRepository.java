package com.iguroo.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iguroo.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
