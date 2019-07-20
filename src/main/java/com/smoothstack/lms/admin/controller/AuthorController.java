package com.smoothstack.lms.admin.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smoothstack.lms.admin.dao.AuthorDAO;
import com.smoothstack.lms.admin.entity.Author;

@RestController
@RequestMapping("/admin")
public class AuthorController {

	@Autowired
	AuthorDAO authDAO;
	
	@GetMapping(value ="/author")
	public List<Author> getAllPublishers(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return authDAO.findAll(limit).getContent();
	}	
	
	
	@GetMapping(value = "/author/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
		Optional<Author> auth = authDAO.findById(id);		
				
		return !auth.isPresent() ? new ResponseEntity<Author>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Author>(auth.get(), HttpStatus.OK);						 
	}
	
	@PostMapping(value ="/author")
	@ResponseStatus(HttpStatus.CREATED)
	public Author createAuthor(@Valid @RequestBody Author auth) {
		return authDAO.save(auth);
	}	

	@PutMapping(value ="/author")
	@ResponseStatus(HttpStatus.OK)
	public Author updateAuthor(@Valid @RequestBody Author auth) {
		return authDAO.save(auth);
	}	
	
	
	
}
