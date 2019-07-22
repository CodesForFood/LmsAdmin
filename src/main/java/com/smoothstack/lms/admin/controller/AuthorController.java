package com.smoothstack.lms.admin.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smoothstack.lms.admin.entity.Author;
import com.smoothstack.lms.admin.service.AuthorService;

@RestController
@RequestMapping("/admin")
public class AuthorController {

	@Autowired
	private AuthorService authService;
	
	@GetMapping(value ="/authors")
	public List<Author> getAllAuthors(@RequestParam(required = false, defaultValue = "100") int size) {		
		return authService.getAllAuthors(size);
	}	
	
	
	@GetMapping(value = "/author/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
		return authService.getAuthorById(id);								 
	}
	
	@PostMapping(value ="/author")
	@ResponseStatus(HttpStatus.CREATED)
	public Author createAuthor(@Valid @RequestBody Author auth) {
		return authService.createAuthor(auth);
	}	

	@PutMapping(value ="/author")
	@ResponseStatus(HttpStatus.OK)
	public Author updateAuthor(@Valid @RequestBody Author auth) {
		return authService.updateAuthor(auth);
	}	
	
	
	
}
