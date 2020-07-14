package com.lessons.service.impl;

import com.lessons.entity.Employee;
import com.lessons.repository.EmployeeRepository;
import com.lessons.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Employee update(Employee newEmployee, Long id) {
        Employee employee = getById(id);
        employee.setDepartment(newEmployee.getDepartment());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setSalary(newEmployee.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void changeFirstName(String firstName, Long id) {
        Employee employee = employeeRepository.findOne(id);
        employee.setFirstName(firstName);
        employeeRepository.save(employee);
    }
}
