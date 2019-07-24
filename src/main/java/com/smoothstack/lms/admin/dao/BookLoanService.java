package com.smoothstack.lms.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.admin.entity.BookLoan;
import com.smoothstack.lms.admin.entity.BookLoanId;

@Repository
public interface BookLoanService extends JpaRepository<BookLoan, BookLoanId>{

}
