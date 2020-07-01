package com.lessons;

import com.lessons.entity.Department;
import com.lessons.entity.Employee;
import com.lessons.repository.DepartmentRepository;
import com.lessons.repository.EmployeeRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Department department1 = new Department("department1", null);
        Employee employee1 = new Employee("Vlad", "Zhuravlev", 80000.00, department1);


        departmentRepository.save(department1);
        employeeRepository.save(employee1);

        List<Department> departments = departmentRepository.findAll();
        for (Department department:
             departments) {
            System.out.println(department);
        }
    }
}
