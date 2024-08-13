package com.example.rest_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeManagerTest {
    @Mock
    private Employees employees;
    @InjectMocks
    private EmployeeManager employeeManager;
    @Test
    void getAllEmployee(){

        var employeeList = employeeManager.getAllEmployees();
        //then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(3);
    }
    @Test
    void addEmployee(){
        //given
        Employee emp1 = new Employee(4, "endy", "li", "123@gmail.com", "manager");
        Employee emp2 = new Employee(5, "engen", "pi", "23@gmail.com", "member");
        //when
        List<Employee> existEmployee = employeeManager.getAllEmployees();
        existEmployee.add(emp1);
        existEmployee.add(emp2);
        var employeeList = employeeManager.getAllEmployees();
        //then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(5);
    }

}
