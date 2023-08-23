package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
     @Autowired
     ApiService a;
     
     @PostMapping("/")
     public Student add(@RequestBody Student s)
     {
    	 return a.saveinfo(s);
     }
     @GetMapping("{id}")
     public Optional<Student> getbyId(@PathVariable int id) 
     {
    	 return a.getId(id);
     }
     @GetMapping("/")
     public List<Student> view()
     {
    	 return a.showinfo();
     }
     @PutMapping("/{id}")
     public Student modify(@RequestBody Student s)
     {
    	 return a.update(s);
     }
     @DeleteMapping("/{id}")
     public String deletebyid(@PathVariable int id) {
    	 return a.deleteid(id);
     }
}
