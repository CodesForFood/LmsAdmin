package com.smoothstack.lms.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.admin.dao.BookLoanService;

@RestController
@RequestMapping("/admin")
public class AdminBookLoanContoller {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private BookLoanService loanService;
	
	
}
