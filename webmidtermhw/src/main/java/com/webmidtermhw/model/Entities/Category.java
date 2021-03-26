package com.webmidtermhw.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity  //means objects need to be created from that class, and this object will be used for communication
@Table(name = "category") //if we dont add table annotation, our table name will be same as class name..
//as we want table name being different, we are adding table annotation.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //increase value of this column automatically for each record
    private Long id;

    private String name;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Book> books;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
