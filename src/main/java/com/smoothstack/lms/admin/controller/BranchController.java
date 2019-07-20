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

import com.smoothstack.lms.admin.dao.BranchDAO;
import com.smoothstack.lms.admin.entity.LibraryBranch;

@RestController
@RequestMapping("/admin")
public class BranchController {

	@Autowired
	private BranchDAO branchDAO;
	
	@GetMapping(value ="/branchs")
	public List<LibraryBranch> getAllBranches(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return branchDAO.findAll(limit).getContent();
	}	
	
	
	@GetMapping(value = "/branch/{id}")
	public ResponseEntity<LibraryBranch> getBranchById(@PathVariable Integer id) {
		Optional<LibraryBranch> branch = branchDAO.findById(id);		
				
		return !branch.isPresent() ? new ResponseEntity<LibraryBranch>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<LibraryBranch>(branch.get(), HttpStatus.OK);						 
	}
	
	@PostMapping(value ="/branch")
	@ResponseStatus(HttpStatus.CREATED)
	public LibraryBranch createBranch(@Valid @RequestBody LibraryBranch branch) {
		return branchDAO.save(branch);
	}	

	@PutMapping(value ="/branch")
	@ResponseStatus(HttpStatus.OK)
	public LibraryBranch  updateBranch(@Valid @RequestBody LibraryBranch branch) {				
		return branchDAO.save(branch);
	}	
	
	
}