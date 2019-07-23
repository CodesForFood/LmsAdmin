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

import com.smoothstack.lms.admin.Const;
import com.smoothstack.lms.admin.entity.LibraryBranch;
import com.smoothstack.lms.admin.service.BranchService;

@RestController
@RequestMapping("/admin")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@GetMapping(value ="/branches", produces = { Const.XML, Const.JSON })
	public List<LibraryBranch> getAllBranches(@RequestParam(required = false, defaultValue = "100") int size) {		
		return branchService.getAllBranches(size);
	}	
	
	
	@GetMapping(value = "/branch/{id}", produces = { Const.XML, Const.JSON })
	public ResponseEntity<LibraryBranch> getBranchById(@PathVariable Integer id) {
		return branchService.getBranchById(id);					 								 
	}
	
	@PostMapping(value ="/branch", produces = { Const.XML, Const.JSON }, consumes = { Const.XML, Const.JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public LibraryBranch createBranch(@Valid @RequestBody LibraryBranch branch) {
		return branchService.createBranch(branch);
	}	

	@PutMapping(value ="/branch", produces = { Const.XML, Const.JSON }, consumes = { Const.XML, Const.JSON })
	@ResponseStatus(HttpStatus.OK)
	public LibraryBranch  updateBranch(@Valid @RequestBody LibraryBranch branch) {				
		return branchService.updateBranch(branch);
	}	
	
	
}
