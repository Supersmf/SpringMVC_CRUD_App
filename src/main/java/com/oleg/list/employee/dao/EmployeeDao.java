package com.oleg.list.employee.dao;

import com.oleg.list.employee.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(int id);

    public Employee getEmployeeById(int id);

    public List<Employee> listEmployees();

    public List<Employee> sortListEmployees(String param);
}
