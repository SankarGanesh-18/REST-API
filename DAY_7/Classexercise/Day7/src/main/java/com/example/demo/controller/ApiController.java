package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
       @Autowired
       ApiService a;
       
       @PostMapping("/")
       public Car savedetails(@RequestBody Car c)
       {
    	   return a.saveowner(c);
       }
       
       @GetMapping("showdetails")
       public List<Car> show()
       {
     	  return a.showinfo();
       }
       
       @GetMapping("owners/{owners}")
       public List<Car> getOwn(@PathVariable int owners)
       {
    	   return a.getOwner(owners);
       }
       
       @GetMapping("address/{address}")
       public List<Car> getAddress(@PathVariable String address)
       {
    	   return a.getAddress(address);
       }
       
       @GetMapping("carName/{carName}")
       public List<Car> getCarName(@PathVariable String carName)
       {
    	   return a.getCar(carName);
       }
       
       @GetMapping("owners/{owners}/cartype/{carType}")
       public List<Car> getand(@PathVariable int owners, @PathVariable String carType)
       {
    	   return a.getCarand(owners,carType);
       }
       
       @GetMapping("owners/{owners}/cartype/{cartype}/or")
       public List<Car> getor(@PathVariable int owners, @PathVariable String cartype)
       {
    	   return a.getCaror(owners,cartype);
       }
}
