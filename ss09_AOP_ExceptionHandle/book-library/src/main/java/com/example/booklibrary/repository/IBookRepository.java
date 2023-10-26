package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
//    void rentBook(Long id, Long rentingId);
}
