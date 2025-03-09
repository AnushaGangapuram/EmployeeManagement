package com.iguroo.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iguroo.ems.entity.Employee;

public interface EmployRespository extends JpaRepository<Employee, Long> {

}
