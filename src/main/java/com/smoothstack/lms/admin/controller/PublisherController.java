package com.smoothstack.lms.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.smoothstack.lms.admin.entity.Publisher;
import com.smoothstack.lms.admin.service.PublisherService;

@RestController
@RequestMapping("/admin")
public class PublisherController {
	
	@Autowired
	private PublisherService pubService;
	
	@GetMapping(value ="/publishers")
	public List<Publisher> getAllPublishers(@RequestParam(required = false, defaultValue = "100") int size) {
		return pubService.getAllPublishers(size);
	}	
	
	
	@GetMapping(value = "/publisher/{id}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer id) {
		return pubService.getPublisherById(id);							 
	}
	
	@PostMapping(value ="/publisher")
	@ResponseStatus(HttpStatus.CREATED)
	public Publisher createPublisher(@Valid @RequestBody Publisher pub) {
		return pubService.createPublisher(pub);
	}	

	@PutMapping(value ="/publisher")
	@ResponseStatus(HttpStatus.OK)
	public Publisher updatePublisher(@Valid @RequestBody Publisher pub) {
		return pubService.updatePublisher(pub);
	}	
	
}
