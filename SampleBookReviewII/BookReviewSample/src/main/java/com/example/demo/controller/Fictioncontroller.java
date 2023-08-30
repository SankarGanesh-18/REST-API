package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fictionmodel;
import com.example.demo.service.Fictionservice;

@RestController
public class Fictioncontroller {
	@Autowired
	Fictionservice fs;
	
	@PostMapping("addreview")
	public Fictionmodel saving(@RequestBody Fictionmodel fm)
	{
		return fs.saveinfo(fm);
	}
	
	@PostMapping("addnreview")
    public List<Fictionmodel> addn(@RequestBody List<Fictionmodel> fm)
    {
  	  return fs.savedetails(fm);
    }
	
	@GetMapping("showreview")
	public List<Fictionmodel> show()
	{
		return fs.showinfo();
	}
	
	@PutMapping("updatereview")
    public Fictionmodel modify(@RequestBody Fictionmodel fm)
    {
  	  return fs.updateinfo(fm);
    }
	
	@PutMapping("updatereviewbyid/{id}")
    public String modifyall(@PathVariable int id, @RequestBody Fictionmodel fm)
    {
  	  return fs.updateinfoid(id,fm);
    }
	
	@DeleteMapping("deletereview")
	public String del(@RequestBody Fictionmodel fm)
    {
  	  fs.deleteinfo(fm);
  	  return "Deleted successfully";
    }
	
	@DeleteMapping("ByreviewId/{id}")
    public void deletebyid(@PathVariable int id)
    {
  	  fs.deletereviewid(id);
    }
	
	@GetMapping("{id}")
    public Optional<Fictionmodel> readbyId(@PathVariable int id)
    {
  	  return fs.readreviewId(id);
    }
	//normal
	@GetMapping("sortasc/{name}")
	public List<Fictionmodel> sortainfo(@PathVariable String name)
	{
		return fs.getaSorted(name);
	}
	
	//descending
	@GetMapping("sortdesc/{name}")
	public List<Fictionmodel> sortinfo(@PathVariable String name)
	{
		return fs.getSorted(name);
	}
	
	//Pagination
	@GetMapping("paging/{pgno}/{pgsize}")
	public List<Fictionmodel> showpginfo(@PathVariable int pgno, @PathVariable int pgsize)
	{
		return fs.getPage(pgno, pgsize);
	}
	
	//Sorting and Pagination
	@GetMapping("pagsort/{pgno}/{pgsize}/{dr}/{}")
	public List<Fictionmodel> showpgsortinfo(@PathVariable int pgno, @PathVariable int pgsize ,@PathVariable Sort.Direction dr, @PathVariable String name)
	{
		return fs.getPageandSort(pgno, pgsize,dr,name);
	}
	
	//OR OPERATION
	@GetMapping("/getnew/{id}/{year}")
	public List<Fictionmodel> displayall(@PathVariable int id, @PathVariable int year)
	{
		return fs.get(id, year);
	}
	
	//AND OPERATION
	@GetMapping("/getandnew/{id}/{year}")
	public List<Fictionmodel> displayand(@PathVariable int id, @PathVariable int year)
	{
		return fs.getand(id, year);
	}
	
	//Searching with first name
	@GetMapping("get/{name}")
	public List<Fictionmodel> displayallf(@PathVariable String name)
	{
		return fs.getf(name);
	}
	
	//DELETE OPERATION
	@DeleteMapping("deletequery/{id}")
	public String dels(@PathVariable int id)
	{
		return fs.delstud(id)+" Deleted";
	}
	
	//UPDATE
	@PutMapping("updatequery/{newid}/{oldid}")
	public String upds(@PathVariable int newid, @PathVariable int oldid)
	{
		return fs.updatestud(newid,oldid)+" Updated";
	}
	
	//Select name
	@GetMapping("BookName")
	public List<String> showw()
	{
		return fs.sshow();
	}
}
