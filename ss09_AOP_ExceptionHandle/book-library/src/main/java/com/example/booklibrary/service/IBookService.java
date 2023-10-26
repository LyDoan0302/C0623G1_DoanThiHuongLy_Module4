package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.bind.Unmarshaller;
import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    List<Book> findAll();
    Book findById(Long id);
//    void rentBook(Long id, Long rentingId);

}
