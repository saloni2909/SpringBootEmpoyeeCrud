package com.saluj.springbootemployeecrud.services;

import com.saluj.springbootemployeecrud.model.Employee;
import com.saluj.springbootemployeecrud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSvc {

    @Autowired
    private EmployeeRepo emprepo;






    public Employee saveEmp(Employee emp){
        return emprepo.save(emp);
    }

    public List<Employee> getEmp(){
        return emprepo.findAll();
    }

    public Optional<Employee> getEmpById(Long id){
        return emprepo.findById(id);
    }

    public Employee updateMbl(Long id, Long contact){
        Employee emp = emprepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("person with "+id+" does not exist")
        );
        emp.setContact(contact);
        return emprepo.save(emp);

    }
}
