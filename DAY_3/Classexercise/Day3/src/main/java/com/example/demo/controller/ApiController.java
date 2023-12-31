package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService x;
	@PostMapping("/")
	public Employee add(@RequestBody Employee e)
	{
		return x.saveinfo(e);
	}
	@GetMapping("{id}")
    public Optional<Employee> readbyId(@PathVariable int id)
    {
  	  return x.readId(id);
    }
	@GetMapping("/")
	public List<Employee> showinfo()
	{
		return x.show();
	}
}
