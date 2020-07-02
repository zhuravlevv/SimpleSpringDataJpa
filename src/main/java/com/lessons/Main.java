package com.lessons;

import com.lessons.entity.Department;
import com.lessons.entity.Employee;
import com.lessons.repository.DepartmentRepository;
import com.lessons.repository.EmployeeRepository;
import com.lessons.service.DepartmentService;
import com.lessons.service.EmployeeService;
import com.lessons.service.impl.DepartmentServiceImpl;
import com.lessons.service.impl.EmployeeServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        EmployeeService employeeService = context.getBean(EmployeeServiceImpl.class);
        DepartmentService departmentService = context.getBean(DepartmentServiceImpl.class);

        Department department1 = new Department("department1", null);
        Employee employee1 = new Employee("Vlad", "Zhuravlev", 80000.00, department1);

        departmentService.add(department1);
        employeeService.add(employee1);

//        List<Department> departments = departmentRepository.findAll();
//        for (Department department:
//             departments) {
//            System.out.println(department);
//        }

        List<Employee> employees = employeeService.findByDepartmentId(1L);
        System.out.println(employees);
    }
}
