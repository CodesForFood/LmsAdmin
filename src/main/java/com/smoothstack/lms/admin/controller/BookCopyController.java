package com.smoothstack.lms.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.admin.entity.BookCopies;
import com.smoothstack.lms.admin.service.BookCopyService;

@RestController
@RequestMapping("/admin")
public class BookCopyController {

	@Autowired
	private BookCopyService bookCopyService;
	
	
	@GetMapping(value = "/noOfBooks", produces = "application/json", consumes = "application/json")
	public List<BookCopies> getAllBookCopies(@RequestParam(required = false, defaultValue = "100") int size) {		
		return bookCopyService.getAllBookCopies(size);
	}
	
	
	@GetMapping(value = "/noOfBook/ofBook/{bookId}/inBranch/{branchId}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BookCopies> getBookCopiesByBookAndBranch(@PathVariable Integer bookId, @PathVariable Integer branchId){
		return bookCopyService.getBookCopiesByBookAndBranch(bookId, branchId);								
	}
	
	@GetMapping(value = "/noOfBook/ofBook/{bookId}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<BookCopies>> getBookCopiesByBook(@PathVariable Integer bookId){
		return bookCopyService.getBookCopiesByBook(bookId);			
	}
	
	@GetMapping(value = "/noOfBook/inBranch/{branchId}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<BookCopies>> getBookCopiesOfBranch(@PathVariable Integer branchId){
		return bookCopyService.getBookCopiesOfBranch(branchId);		

	}
	
	@PostMapping(value = "/noOfBook", produces = "application/json", consumes = "application/json")
	public BookCopies addBookCopies(@RequestBody BookCopies bookCopies) {		
		return bookCopyService.addBookCopies(bookCopies);
		
	}
	
	@PutMapping(value = "/noOfBook", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BookCopies> updateBookCopies(@RequestBody BookCopies bookCopies) {
		return bookCopyService.updateBookCopies(bookCopies);
	}	
}

