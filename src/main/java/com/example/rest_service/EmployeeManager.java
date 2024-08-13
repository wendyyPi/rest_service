package com.example.rest_service;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeManager {
    private static Employees employees = new Employees();

    static{
        Employee emp1 = new Employee(1, "Wendy", "li", "123@gmail.com", "manager");
        Employee emp2 = new Employee(2, "Mengen", "pi", "23@gmail.com", "member");
        Employee emp3 = new Employee(3, "Hetao", "li", "3@gmail.com", "executive member");
        employees.getEmployeeList().add(emp1);
        employees.getEmployeeList().add(emp2);
        employees.getEmployeeList().add(emp3);
    }
    public List<Employee> getAllEmployees()
    {

        return employees.getEmployeeList();
    }
    public void addEmployee(Employee employee){
        employees.getEmployeeList().add(employee);
    }
    public int findEmployee(Employee employee){
        Integer id = employee.getEmployee_id();
        int finded = -1;
        for(Employee element : employees.getEmployeeList()){
            if (element.getEmployee_id().equals(id)){
                finded = employees.getEmployeeList().indexOf(element);
                break;
            }
        }
        return finded;
    }
    public void editEmployee(Employee employee){
        Integer index = findEmployee(employee);
        if (index != -1) {
            employees.getEmployeeList().set(index, employee);
        } else {
            System.out.println("Employee not found!");
        }
    }

}
