package com.smoothstack.lms.admin.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.admin.dao.BookDAO;
import com.smoothstack.lms.admin.entity.Book;

@RestController
@RequestMapping("/admin")
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	
	
	@GetMapping(value ="/book")
	public List<Book> getAllBooks(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return bookDAO.findAll(limit).getContent();
	}	
	
	
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		Optional<Book> book = bookDAO.findById(id);		
				
		return !book.isPresent() ? new ResponseEntity<Book>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Book>(book.get(), HttpStatus.OK);						 
	}
	
	@PostMapping(value ="/book")
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@Valid @RequestBody Book book) {
		return bookDAO.save(book);
	}	

	@PutMapping(value ="/book")
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@Valid @RequestBody Book book) {
		return bookDAO.save(book);
	}	
	
}
