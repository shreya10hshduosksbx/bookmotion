package com.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.Entities.Book;

public interface Bookrepository extends CrudRepository<Book,Integer>{

	public Book findById(int id);
	
}
