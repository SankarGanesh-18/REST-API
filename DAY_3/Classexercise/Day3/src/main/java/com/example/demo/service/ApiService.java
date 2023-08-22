package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

import com.example.demo.repository.EmployeeRepo;

@Service
public class ApiService{
	@Autowired
    EmployeeRepo a;
    public Employee saveinfo(Employee e)
    {
    	return a.save(e);
    }
    public List<Employee> show()
    {
    	return a.findAll();
    }
    public Optional<Employee> readId(int id) {
        
        return a.findById(id);
    }
}
