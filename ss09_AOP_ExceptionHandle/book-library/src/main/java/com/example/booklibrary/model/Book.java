package com.example.booklibrary.model;

import org.apache.catalina.startup.SetAllPropertiesRule;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String img;
    private int quantity;
  @OneToMany(mappedBy = "book")
  private Set<RentingBook> rentingBooks;

    public Book(){}

    public Book(Long id, String title, String author, String img, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.img = img;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Set<RentingBook> getRentingBooks() {
        return rentingBooks;
    }

    public void setRentingBooks(Set<RentingBook> rentingBooks) {
        this.rentingBooks = rentingBooks;
    }
}
