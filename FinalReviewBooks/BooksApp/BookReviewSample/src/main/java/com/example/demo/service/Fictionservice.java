package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
   //deletebyQuery
 	public void deletepid(int id)
 	{
 		fr.deleteById(id);
 	}
 	
 	//Sorting only
 	public List<Fictionmodel> getaSorted(String str)
 	{
 		return fr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, str));
 	}
 	
 	//Sorting only in descending
 	public List<Fictionmodel> getSorted(String str)
 	{
 		return fr.findAll(Sort.by(Sort.Direction.DESC, str));
 	}
 	
 	//Pagination and sorting
 	public List<Fictionmodel> getPageandSort(int pgno,int pgsize,Sort.Direction dt,String str)
 	{
 		Page<Fictionmodel> p = fr.findAll(PageRequest.of(pgno, pgsize, dt, str));
 		return p.getContent();
 	}
 	
 	//Pagination only
 	public List<Fictionmodel> getPage(int pgno,int pgsize)
 	{
 		Page<Fictionmodel> p = fr.findAll(PageRequest.of(pgno, pgsize));
 		return p.getContent();
 	}
 	
 	//JPQL OR
 	public List<Fictionmodel> get(int s, int b)
 	{
 		return fr.getinfo(s,b);
 	}
 	
 	//JPQL AND
 	public List<Fictionmodel> getand(int s, int b)
 	{
 		return fr.getandinfo(s,b);
 	}
 	
 	//JPQL LIKE-F
 	public List<Fictionmodel> getf(String b)
 	{
 		return fr.getfinfo(b);
 	}
 	
 	//JPQL DELETE
 	public int delstud(int id)
 	{
 		return fr.delete(id);
 	}
 	
 	//JPQL UPDATE
 	public int updatestud(int id,int id1)
 	{
 		return fr.updat(id, id1);
 	}
 	
 	//JPQL Select name
 	public List<String> sshow()
 	{
 		return fr.getbinfo();
 	}
 	public List<Fictionmodel> sshove(String m)
 	{
 		return fr.getallinfo(m);
 	}
}
