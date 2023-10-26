package com.example.booklibrary.repository;

import com.example.booklibrary.model.RentingBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentingBookRepository extends JpaRepository<RentingBook, Long> {
}
