package com.webmidtermhw.model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "picked_books")
public class PickedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date pickDate;

    private boolean droppedOff;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public PickedBook(Book book, User user) {
        this.book = book;
        this.user = user;
        this.droppedOff = false;
    }

    public PickedBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public boolean isDroppedOff() {
        return droppedOff;
    }

    public void setDroppedOff(boolean droppedOff) {
        this.droppedOff = droppedOff;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
