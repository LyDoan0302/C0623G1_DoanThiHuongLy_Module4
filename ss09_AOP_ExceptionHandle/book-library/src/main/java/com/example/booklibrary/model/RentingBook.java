package com.example.booklibrary.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rentingId;

    private boolean isReturn;
 @ManyToOne
 @JoinColumn(name="book_id", referencedColumnName = "id")
 private Book book;
    public RentingBook() {}

    public RentingBook(Long id, Long rentingId, boolean isReturn, Book book) {
        this.id = id;
        this.rentingId = rentingId;
        this.isReturn = isReturn;
        this.book = book;
    }

    public RentingBook(Long id, Long rentingId, boolean isReturn) {
        this.id = id;
        this.rentingId = rentingId;
        this.isReturn = isReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentingId() {
        return rentingId;
    }

    public void setRentingId(Long rentingId) {
        this.rentingId = rentingId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }
}
