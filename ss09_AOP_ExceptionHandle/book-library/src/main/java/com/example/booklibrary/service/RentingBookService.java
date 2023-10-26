package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.model.RentingBook;
import com.example.booklibrary.repository.IRentingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentingBookService implements IRentingBookService{
    @Autowired
    private IRentingBookRepository iRentingBookRepository;

    @Override
    public List<RentingBook> findAll() {
        return iRentingBookRepository.findAll();
    }

    @Override
    public void save(RentingBook rentingBook) {
        iRentingBookRepository.save(rentingBook);

    }

    @Override
    public RentingBook findById(Long id) {
        return iRentingBookRepository.findById(id).get();
    }

    @Override
    public Book findBookByReference(Long id) {
        return iRentingBookRepository.getReferenceById(id).getBook();
    }

    @Override
    public void deleteRentingBook(Long rentingId) {
        iRentingBookRepository.deleteById(rentingId);
    }


}
