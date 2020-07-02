package com.lessons.service;

import com.lessons.entity.Department;
import com.lessons.entity.Employee;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAll();

    public Department getById(Long id);

    public Department update(Department newDepartment, Long id);

    public Department add(Department employee);

    public void delete(Long id);
}
