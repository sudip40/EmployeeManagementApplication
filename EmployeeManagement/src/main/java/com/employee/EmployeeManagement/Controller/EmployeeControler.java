package com.employee.EmployeeManagement.Controller;

import com.employee.EmployeeManagement.Entity.Employee;
import com.employee.EmployeeManagement.Exceptions.EmployeeException;
import com.employee.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
    @Autowired
    EmployeeService employeeService;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Employee employee) throws EmployeeException{
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() throws EmployeeException{
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Integer id) throws EmployeeException{
        return new ResponseEntity<>(employeeService.remove(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Employee employee) throws EmployeeException{
        return new ResponseEntity<>(employeeService.update(employee), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") Integer id) throws EmployeeException{
        return new ResponseEntity<>(employeeService.get(id), HttpStatus.FOUND);
    }
}
