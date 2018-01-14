package com.p.SpringProject;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.annotation.Id;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Customer {

    @Id
    private Integer id;

    private String name;

    private String address;

    private String phone;

    private static final AtomicInteger count = new AtomicInteger(0);

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = count.incrementAndGet();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}