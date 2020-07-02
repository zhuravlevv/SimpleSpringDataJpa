package com.lessons.service.impl;

import com.lessons.entity.Department;
import com.lessons.repository.DepartmentRepository;
import com.lessons.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public Department update(Department newDepartment, Long id) {
        Department department = new Department();
        newDepartment.getEmployees().forEach(department::addEmployee);
        department.setName(newDepartment.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.delete(id);
    }
}
