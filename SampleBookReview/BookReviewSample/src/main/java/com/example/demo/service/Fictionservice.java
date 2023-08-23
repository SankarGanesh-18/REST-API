package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fictionmodel;
import com.example.demo.repository.Fictionrepository;

@Service
public class Fictionservice {
     @Autowired
     Fictionrepository fr;
     
     public Fictionmodel saveinfo(Fictionmodel fm)
     {
    	 return fr.save(fm);
     }
     
     public List<Fictionmodel> savedetails(List<Fictionmodel> fm)
     {
    	 return fr.saveAll(fm);
     }
     
     public List<Fictionmodel> showinfo()
     {
    	 return fr.findAll();
     }
     
     public Fictionmodel updateinfo(Fictionmodel fm)
     {
    	 return fr.saveAndFlush(fm);
     }
     
     public String updateinfoid(int id,Fictionmodel fm)
     {
    	 if(fr.existsById(id))
    	 {
    		 fr.saveAndFlush(fm);
    		 return "Updated";
    	 }
    	 else
    	 {
    		 return "Enter valid id";
    	 }
     }
     
     public void deleteinfo(Fictionmodel fm)
     {
    	 fr.delete(fm);
     }
     
     public void deletereviewid(int id)
     {
    	 fr.deleteById(id);
     }
     
     public Optional<Fictionmodel> readreviewId(int id) {
         
         return fr.findById(id);
            
     }
}
