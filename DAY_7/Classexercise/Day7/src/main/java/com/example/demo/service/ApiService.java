package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;

@Service
public class ApiService {
	@Autowired
	CarRepo cr;
	
	public Car saveowner(Car c)
	{
		return cr.save(c);
	}
    
	public List<Car>  showinfo()
    {
   	 return cr.findAll();
    }
	
	public List<Car> getOwner(int owners)
	{
		return cr.getOwnerInfo(owners);
	}
	
	public List<Car> getAddress(String v)
	{
		return cr.getAddressInfo(v);
	}
	
	public List<Car> getCar(String z)
	{
		return cr.getCarInfo(z);
	}
	
	public List<Car> getCarand(int own,String name)
	{
		return cr.getCarInfoand(own,name);
	}
	
	public List<Car> getCaror(int own,String name)
	{
		return cr.getCarInfoor(own,name);
	}
}
