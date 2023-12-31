package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void update(Book book) {
        iBookRepository.save(book);
    }

//    @Override
//    public void rentBook(Long bookId, Long rentingId) {
//        iBookRepository.rentBook(bookId, rentingId);
//    }
}
