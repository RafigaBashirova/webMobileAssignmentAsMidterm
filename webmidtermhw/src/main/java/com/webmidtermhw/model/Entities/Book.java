package com.webmidtermhw.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webmidtermhw.model.dataTransferObjects.BookModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pickups"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String author;

    private String published_at;

    private Boolean isAvailable;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<PickedBook> pickups = new HashSet<>();

    public Book() {
    }

    public Book(BookModel bookModel) {
        this.name = bookModel.getName();
        this.author = bookModel.getAuthor();
        this.published_at = bookModel.getPublished_at();
        this.isAvailable = bookModel.getAvailable();
    }

    public Set<PickedBook> getPickups() {
        return pickups;
    }

    public void setPickups(Set<PickedBook> pickups) {
        this.pickups = pickups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", author='" + author + '\'' +
                ", published_at='" + published_at + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
