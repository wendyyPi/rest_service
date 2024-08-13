package com.example.rest_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)

public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    EmployeeManager employeeManager;
    Employee emp1 = new Employee(1, "Wendy", "li", "123@gmail.com", "manager");
    Employee emp2 = new Employee(2, "Mengen", "pi", "23@gmail.com", "member");
    Employee emp3 = new Employee(3, "Hetao", "li", "3@gmail.com", "executive member");
    @Test
    public void getAllEmployees_success()throws Exception {
        List<Employee> employees = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));
        Mockito.when(employeeManager.getAllEmployees()).thenReturn(employees);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$",hasSize(3)))
            .andExpect(jsonPath("$[2].employee_id",is(3)));

    }



}
