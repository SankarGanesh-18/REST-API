package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;


@Service
public class ApiService {
       @Autowired
       BookRepo b;
       
       public Book saveinfo(Book ss)
       {
    	   return b.save(ss);
       }
       public Optional<Book> getId(int id)
       {
    	   return b.findById(id);
       }
       public List<Book> showinfo()
       {
    	   return b.findAll();
       }
       public String updateinfoid(int id,Book ss)
       {
      	 if(b.existsById(id))
      	 {
      		 b.saveAndFlush(ss);
      		 return "Updated";
      	 }
      	 else
      	 {
      		 return "Enter valid id";
      	 }
       }
       public String deleteid(int id) {
    	   b.deleteById(id);
    	   return "true";
 
       }
}
