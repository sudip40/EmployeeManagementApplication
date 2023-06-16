package com.employee.EmployeeManagement.Service;

import com.employee.EmployeeManagement.Entity.Employee;
import com.employee.EmployeeManagement.Exceptions.EmployeeException;
import com.employee.EmployeeManagement.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public String add(Employee employee) throws EmployeeException {
        Employee e = employeeRepo.save(employee);
        if(e!=null){
            return "Employee added Successfully";
        }
        throw new EmployeeException("Employee not added Successfully");
    }

    @Override
    public List<Employee> getAll() throws EmployeeException {
        List<Employee> employees = employeeRepo.findAll();
        if(employees.size()>0){
            return employees;
        }
        throw new EmployeeException("No employee to show");
    }

    @Override
    public String remove(Integer id) throws EmployeeException {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            employeeRepo.delete(employee.get());
            return "Employee removed Successfully";
        }
        throw new EmployeeException("No employee found with this Id");
    }

    @Override
    public String update(Employee employee) throws EmployeeException {
        Optional<Employee> emp = employeeRepo.findById(employee.getId());
        if(emp.isPresent()){
            Employee e = employeeRepo.save(employee);
            if(e!=null){
                return "Employee updated Successfully";
            }
            throw new EmployeeException("Employee not updated Successfully");
        }
        throw new EmployeeException("No employee found with this Id");
    }

    @Override
    public Employee get(Integer id) throws EmployeeException {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new EmployeeException("No employee found with this Id");
    }
}
