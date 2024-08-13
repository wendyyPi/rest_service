package com.example.rest_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest

public class EmployeesTest {
    @Mock
    private EmployeeManager employeeManager;
    EmployeeManager nemployeeManager = new EmployeeManager();
    private List<Employee> employeeList=nemployeeManager.getAllEmployees();


//    @BeforeEach
//    void setUp(){
//        employeeList=new ArrayList<>();
//        Mockito.when(employees.getEmployeeList()).thenReturn(employeeList);
//    }
    @Test
    void getEmployee(){
        Employee emp1 = new Employee(4, "sdendy", "li", "123@gmail.com", "manager");
        Employee emp2 = new Employee(5, "sgengen", "pi", "23@gmail.com", "member");
        employeeList.add(emp1);
        employeeList.add(emp2);
        assertThat(employeeList.size()).isEqualTo(5);

    }

}
