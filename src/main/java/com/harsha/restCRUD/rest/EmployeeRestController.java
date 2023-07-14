package com.harsha.restCRUD.rest;

import com.harsha.restCRUD.dao.EmployeeDAO;
import com.harsha.restCRUD.entity.Employee;
import com.harsha.restCRUD.service.EmployeeService;
import com.harsha.restCRUD.service.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "CRUD API's", description = "Various API's for CRUD operations")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        List<Employee> employees=employeeService.findAll();

        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null)
        {
            throw new RuntimeException("Employee not found by id "+employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        employeeService.deleteById(employeeId);

        return "Deleted employee with Id "+employeeId;
    }
}
