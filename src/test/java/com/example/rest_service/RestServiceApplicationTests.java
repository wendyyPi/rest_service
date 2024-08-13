package com.example.rest_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RestServiceApplicationTests {

    @Mock
    private EmployeeManager employeeManager;
    //helper function
    int getEmployeeCount(EmployeeManager employeeManager){
        return employeeManager.getAllEmployees().size();
    }
    @Test
    void createEmployeeManager(){
        EmployeeManager newEmployeeManager = new EmployeeManager();
        assert(getEmployeeCount(newEmployeeManager) == 4);
    }

    @Test
    void addEmployee(){
        EmployeeManager employeeManager = new EmployeeManager();
        int employeeCount = getEmployeeCount(employeeManager);
        Employee employee = new Employee(7, "Dari", "Jones", "dariajones@gmail.com", "Software developer");
        employeeManager.addEmployee(employee);
        assertEquals(4, employeeCount);
        assert(employeeCount+1 == getEmployeeCount(employeeManager));
    }
    @ExtendWith(MockitoExtension.class)
    @BeforeEach void setUp(){
        this.employeeManager=new EmployeeManager();
        Employee newEmployee = new Employee(8, "Daria", "Jones", "dariajones@gmail.com", "Software developer");
        this.employeeManager.addEmployee(newEmployee);
    }
    @Test
    void employeeIdInList(){
        List<Employee> employees = this.employeeManager.getAllEmployees();
        for(int i =0;i<employees.size();i++){
            Employee employee = employees.get(i);
            if(employee.getEmployee_id().equals(8))
            {
                return;
            }

        }
        assert(false);
    }
    @Test
    void employeeFirstNameInList(){
        List<Employee> employees = this.employeeManager.getAllEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getFirst_name() == "Wendy")
            {
                return;
            }
        }
        assert(false);
    }
    @Test
        // Check whether added employee last name is found in last name field
    void employeeLastNameInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getLast_name() == "Jones")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee email is found in email field
    void employeeEmailInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getEmail() == "dariajones@gmail.com")
            {
                return;
            }
        }
        assert(false);
    }

    @Test
        // Check whether added employee title is found in title field
    void employeeTitleInList() {
        List<Employee> employees = this.employeeManager.getAllEmployees();
        for (int i=0; i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            if (employee.getTitle() == "Software developer")
            {
                return;
            }
        }
        assert(false);
    }


}
