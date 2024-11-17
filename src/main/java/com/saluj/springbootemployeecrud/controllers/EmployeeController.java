package com.saluj.springbootemployeecrud.controllers;

import com.saluj.springbootemployeecrud.model.Employee;
import com.saluj.springbootemployeecrud.services.EmployeeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class EmployeeController {

    @Autowired
    public EmployeeSvc empsvc;

    private int id = 2;



    @PostMapping("add")
    public Employee addEmployee(@RequestBody Employee emp){
        return empsvc.saveEmp(emp);
    }

    @GetMapping("findAll")
    public List<Employee> findAllEmployees(){
        return empsvc.getEmp();
    }

    /*@GetMapping("findById")
    public Optional<Employee> findEmployee(Long id){
        return empsvc.getEmpById(emp.getId());
    }*/

    @GetMapping("findById")
    public Optional<Employee> findEmployee(Long id){
        return empsvc.getEmpById(id);
    }


}
