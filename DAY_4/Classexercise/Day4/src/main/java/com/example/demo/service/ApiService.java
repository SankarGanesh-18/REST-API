package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class ApiService {
       @Autowired
       StudentRepo b;
       
       public Student saveinfo(Student ss)
       {
    	   return b.save(ss);
       }
       public Optional<Student> getId(int id)
       {
    	   return b.findById(id);
       }
       public List<Student> showinfo()
       {
    	   return b.findAll();
       }
       public Student update(Student s)
       {
    	   return b.saveAndFlush(s);
       }
       public String deleteid(int id) {
    	   b.deleteById(id);
    	   return "true";
 
       }
}
