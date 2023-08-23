package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fictionmodel;

public interface Fictionrepository extends JpaRepository<Fictionmodel, Integer>{

}
