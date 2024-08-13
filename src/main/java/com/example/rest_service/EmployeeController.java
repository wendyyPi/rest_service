package com.example.rest_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http
    .ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;
    @GetMapping(path="",produces="application/json")
    public List<Employee> getEmployees(){
        return employeeManager.getAllEmployees();
    }
    @PostMapping(path="",consumes = "application/json",produces="application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        Integer id = employeeManager.getAllEmployees().size()+1;
        employee.setEmployee_id(id);
        employeeManager.addEmployee(employee);
        URI location
            = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(
                employee.getEmployee_id())
            .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping(path="",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Object> editEmployee(@RequestBody Employee employee){
        employeeManager.editEmployee(employee);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(employee.getEmployee_id())
            .toUri();
        return ResponseEntity.created(location).build();
    }
}
