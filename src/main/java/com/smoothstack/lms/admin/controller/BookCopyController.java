package com.smoothstack.lms.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.admin.dao.BookCopiesDAO;
import com.smoothstack.lms.admin.entity.BookCopies;

@RestController
@RequestMapping("/admin")
public class BookCopyController {

	@Autowired
	private BookCopiesDAO bookCopyDAO;
	
	
	@GetMapping(value = "/bookcopies")
	public List<BookCopies> getAllBookCopies(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return bookCopyDAO.findAll(limit).getContent();
	}
	
	
}
