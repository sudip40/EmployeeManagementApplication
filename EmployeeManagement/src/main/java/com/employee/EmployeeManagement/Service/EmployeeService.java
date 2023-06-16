package com.employee.EmployeeManagement.Service;

import com.employee.EmployeeManagement.Entity.Employee;
import com.employee.EmployeeManagement.Exceptions.EmployeeException;

import java.util.List;

public interface EmployeeService {
    public String add(Employee employee) throws EmployeeException;
    public List<Employee> getAll() throws EmployeeException;
    public String remove(Integer id) throws EmployeeException;
    public String update(Employee employee) throws EmployeeException;
    public Employee get(Integer id) throws EmployeeException;
}
