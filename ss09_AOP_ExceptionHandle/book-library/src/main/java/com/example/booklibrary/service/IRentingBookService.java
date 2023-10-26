package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.model.RentingBook;

import java.util.List;

public interface IRentingBookService {
    List<RentingBook> findAll();
    void save(RentingBook rentingBook);
    RentingBook findById(Long id);
    Book findBookByReference(Long id);
    void deleteRentingBook(Long rentingId);
}
