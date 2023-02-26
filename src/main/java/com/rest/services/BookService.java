package com.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.Entities.Book;
import com.rest.dao.Bookrepository;


@Component
public class BookService {
//fake service
	
//	private static List<Book> list=new ArrayList<>();
//	static{
//		
//		list.add(new Book(12,"java","xyz"));
//		list.add(new Book(13,"python","abc"));
//		list.add(new Book(14,"javascript","kml"));
//	}
	
	
	//actual db connection
	@Autowired
	private Bookrepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> list= (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		
		Book book=null;
		try{
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			
			this.bookRepository.findById(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return book;
			}
	
	//adding the book
	public Book addBook(Book b) {
	//	list.add(b);
	//	return b;
		
		Book book=bookRepository.save(b);
		return book;
		
	}
	
	
	//delete book
	public void deleteBook(int id) {
		
	//	list.stream().filter(book->book.getId()!= id).collect(Collectors.toList());
		
		bookRepository.deleteById(id);
			
		}

	public void updateBook(Book book,int bookId) {
		
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
		
		
		book.setId(bookId);
		bookRepository.save(book);
	}
	
}
