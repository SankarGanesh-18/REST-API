package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{

	@Query(value = "select * from Car_Table where owners = :s",nativeQuery = true)
	public List<Car> getOwnerInfo(@Param("s") int owners);
	
	@Query(value = "select * from Car_Table where address = :add",nativeQuery = true)
	public List<Car> getAddressInfo(@Param("add") String address);
	
	@Query(value = "select * from Car_Table where car_name = :m",nativeQuery = true)
	public List<Car> getCarInfo(@Param("m") String carName);
	
	@Query(value = "select * from Car_Table where owners = :a and car_type = :b",nativeQuery = true)
	public List<Car> getCarInfoand(@Param("a") int owners, @Param("b") String carType);
	
	@Query(value = "select * from Car_Table where owners = :a or car_type = :b",nativeQuery = true)
	public List<Car> getCarInfoor(@Param("a") int owners, @Param("b") String carType);
}
