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
}
