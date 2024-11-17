package com.saluj.springbootemployeecrud.repository;


import com.saluj.springbootemployeecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
