package com.saluj.springbootemployeecrud.controllers;

import com.saluj.springbootemployeecrud.model.Employee;
import com.saluj.springbootemployeecrud.services.EmployeeSvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class EmployeeController {

    public final EmployeeSvc empsvc;

    public EmployeeController(EmployeeSvc empsvc) {
        this.empsvc = empsvc;
    }


    @PostMapping("add")
    public Employee addEmployee(@RequestBody Employee emp){
        return empsvc.saveEmp(emp);
    }

    @GetMapping("findAll")
    public List<Employee> findAllEmployees(){
        return empsvc.getEmp();
    }



    @GetMapping("/findById/{id}")
    public Optional<Employee> findEmployee(@PathVariable Long id){
        return empsvc.getEmpById(id);
    }

    @PutMapping("/findByMbl/{id}/contact")
    public Employee updateMbl(@PathVariable Long id, @RequestBody Long contact){
        return empsvc.updateMbl(id,contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return empsvc.getEmpById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setContact(updatedEmployee.getContact());
                    return ResponseEntity.ok(empsvc.saveEmp(employee));
                })
                .orElse(ResponseEntity.notFound().build());
    }





}
