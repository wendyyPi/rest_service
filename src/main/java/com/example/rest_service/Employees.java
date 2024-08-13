package com.example.rest_service;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList;

    //getting the employee list
    public List<Employee> getEmployeeList() {
        if(employeeList==null){
            employeeList=new ArrayList<>();
        }
        return employeeList;
    }

    //setting the employee list
    public void setEmployeeList(List employeeList){
        this.employeeList=employeeList;
    }
}
