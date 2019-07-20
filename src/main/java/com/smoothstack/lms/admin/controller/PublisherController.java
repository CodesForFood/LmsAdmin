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

import com.smoothstack.lms.admin.dao.PublisherDAO;
import com.smoothstack.lms.admin.entity.Publisher;

@RestController
@RequestMapping("/admin")
public class PublisherController {
	
	@Autowired
	private PublisherDAO pubDAO;
	
	@GetMapping(value ="/publishers")
	public List<Publisher> getAllPublishers(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return pubDAO.findAll(limit).getContent();
	}	
	
	
	@GetMapping(value = "/publisher/{id}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer id) {
		Optional<Publisher> pub = pubDAO.findById(id); 	
		
		return pub.isPresent() ? new ResponseEntity<Publisher>(pub.get(), HttpStatus.OK)
				: new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);							 
	}
	
	@PostMapping(value ="/publisher")
	@ResponseStatus(HttpStatus.CREATED)
	public Publisher createPublisher(@Valid @RequestBody Publisher pub) {
		return pubDAO.save(pub);
	}	

	@PutMapping(value ="/publisher")
	@ResponseStatus(HttpStatus.OK)
	public Publisher UpdatePublisher(@Valid @RequestBody Publisher pub) {
		return pubDAO.save(pub);
	}	
	
}
