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

import com.smoothstack.lms.admin.dao.AdminBorrowerDAO;
import com.smoothstack.lms.admin.entity.Borrower;

@RestController
@RequestMapping("/admin")
public class AdminBorrowerController {

	@Autowired
	private AdminBorrowerDAO borrDAO;
	
	@GetMapping(value ="/borrowers")
	public List<Borrower> getAllBorrowers(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return borrDAO.findAll(limit).getContent();
	}		
	
	@GetMapping(value = "/borrower/{cardNo}")
	public ResponseEntity<Borrower> getBorrowerById(@PathVariable Integer cardNo) {
		Optional<Borrower> borr = borrDAO.findById(cardNo);		
				
		return !borr.isPresent() ? new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Borrower>(borr.get(), HttpStatus.OK);						 
	}
	
	@PostMapping(value ="/borrower")
	@ResponseStatus(HttpStatus.CREATED)
	public Borrower createBorrower(@Valid @RequestBody Borrower borr) {
		return borrDAO.save(borr);
	}	

	@PutMapping(value ="/borrower")
	@ResponseStatus(HttpStatus.OK)
	public Borrower updateBorrower(@Valid @RequestBody Borrower borr) {
		return borrDAO.save(borr);
	}	
	
}
