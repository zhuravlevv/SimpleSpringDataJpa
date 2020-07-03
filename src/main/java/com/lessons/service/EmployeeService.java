package com.lessons.service;

import com.lessons.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getById(Long id);

    public List<Employee> findByDepartmentId(Long id);

    public Employee update(Employee newEmployee, Long id);

    public Employee add(Employee employee);

    public void delete(Long id);

    public void changeFirstName(String firstName, Long id);
}
