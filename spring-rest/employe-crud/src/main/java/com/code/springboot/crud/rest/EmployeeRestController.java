package com.code.springboot.crud.rest;

import com.code.springboot.crud.entity.Employee;
import com.code.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService TheemployeeService) {
        employeeService = TheemployeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee Id is not found " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employe of this id is not found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id: " + employeeId;
    }
}


















