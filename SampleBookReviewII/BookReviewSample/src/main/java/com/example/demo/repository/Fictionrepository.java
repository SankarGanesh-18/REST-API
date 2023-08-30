package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Fictionmodel;

import jakarta.transaction.Transactional;

public interface Fictionrepository extends JpaRepository<Fictionmodel, Integer>{
	@Query(value = "select* from books_review where book_id=:s or yop=:d",nativeQuery = true)
	public List<Fictionmodel> getinfo(@Param("s") int book_id, @Param("d") int yop);
	
	@Query(value = "select* from books_review where book_id=:s and yop=:d",nativeQuery = true)
	public List<Fictionmodel> getandinfo(@Param("s") int book_id, @Param("d") int yop);
	
	@Query(value = "select* from books_review where author like :key%",nativeQuery = true)
	public List<Fictionmodel> getfinfo(@Param("key")String key);
	
	@Modifying
	@Transactional
	@Query( value = "delete from books_review where  book_id=:s",nativeQuery = true)
	public int delete(@Param("s") int book_id);

	@Modifying
	@Transactional
	@Query( value = "update books_review set book_id=?1 where book_id=?2",nativeQuery = true)
	public int updat(int newbook_id,int oldbook_id);
	
	@Query(value = "select book_name from books_review",nativeQuery = true)
	public List<String> getbinfo();

}
