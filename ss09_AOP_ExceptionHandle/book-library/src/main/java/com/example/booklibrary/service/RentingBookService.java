package com.example.booklibrary.service;

import com.example.booklibrary.exception.ExceptionHandle;
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
    public RentingBook findRentingBooksByRentingId(Long rentingId) throws ExceptionHandle {
        return iRentingBookRepository.findRentingBooksByRentingId(rentingId);
    }


//    @Override
//    public void deleteRentingBook(Long rentingId) {
//        iRentingBookRepository.deleteById(rentingId);
//    }


}
