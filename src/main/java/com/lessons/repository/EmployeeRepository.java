package com.lessons.repository;

import com.lessons.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByLastName(String lastName);

    List<Employee> findByDepartmentId(Long departmentId);
}

