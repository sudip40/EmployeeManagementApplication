package com.employee.EmployeeManagement.Repo;

import com.employee.EmployeeManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
