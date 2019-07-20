package com.smoothstack.lms.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.admin.entity.BookCopies;
import com.smoothstack.lms.admin.entity.BookCopyId;

public interface BookCopiesDAO extends JpaRepository<BookCopies, BookCopyId>{

}
