package io.quarkus.samples.petclinic.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;



@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

  

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "date")
    @JsonbDateFormat("yyyy/MM/dd")
    private LocalDate date;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;

    @Column(name = "postIndex")
    @NotNull
    private Integer postIndex;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    // private Set<Visit> visits;


    public Order() {
        this.date = LocalDate.now();
    }
}
