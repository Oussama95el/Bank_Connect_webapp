package com.simplon.bank_connect.client;


import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "client_seq")
    private Long id;

    private String name;

    private String email;

    private String address;

    private String phone;

    private String cin;

    public Client(Long id, String name, String email, String address, String phone, String cin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cin = cin;
    }

    public Client() {
    }

    public Client(String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Client{" + " " +
                "id = " + id +
                ", name = " + name +
                ", email = " + email +
                ", address = " + address +
                ", phone = " + phone +
                ", cin = " + cin +'}';
    }



}