package com.webmidtermhw.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webmidtermhw.model.dataTransferObjects.RegistrationModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity  //means objects need to be created from that class, and this object will be used for communication
@Table(name = "users")  //if we dont add table annotation, our table name will be same as class name..
//as we want table name being different, we are adding table annotation.

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pickedBook"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //increase value of this column automatically for each record
    private Long id;

    private String firstname;

    private String lastname;

    private String birthday;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<PickedBook> pickedBook = new HashSet<>();

    public User() {
    }

    public User(RegistrationModel registrationModel) {
        this.firstname = registrationModel.getFirstname();
        this.lastname = registrationModel.getLastname();
        this.birthday = registrationModel.getBirthday();
        this.password = registrationModel.getPassword();
        this.email = registrationModel.getEmail();
    }

    public Set<PickedBook> getPickedBook() {
        return pickedBook;
    }

    public void setPickedBook(Set<PickedBook> pickedBooks) {
        this.pickedBook = pickedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
