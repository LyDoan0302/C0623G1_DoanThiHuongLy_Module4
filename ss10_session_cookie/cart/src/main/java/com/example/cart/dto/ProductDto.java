package com.example.cart.dto;

import java.util.Objects;

public class ProductDto {
    private Long id;
    private String title;
    private Long price;
    private String img;
    private String author;
    private String description;
    public ProductDto(){}

    public ProductDto(Long id, String title, Long price, String img, String author, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.img = img;
        this.author = author;
        this.description = description;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return  id == that.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
