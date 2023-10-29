package com.example.booklibrary.service;

import com.example.booklibrary.exception.ExceptionHandle;
import com.example.booklibrary.model.RentingBook;

import java.util.List;

public interface IRentingBookService {
    List<RentingBook> findAll();
    void save(RentingBook rentingBook);
    RentingBook findById(Long id);
    RentingBook findRentingBooksByRentingId(Long rentingId) throws ExceptionHandle;
//    void deleteRentingBook(Long rentingId);
}
