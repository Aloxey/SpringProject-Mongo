package com.p.SpringProject;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.annotation.Id;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {

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

    public void setPhone(String phone) throws Exception{
        if (!validatePhoneNumber(phone)){
            throw new IllegalArgumentException();
        }
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        //if (!validateName(name)){
        //    throw new IllegalArgumentException();
        //}
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (!validateEmailAddress(address)){
            throw new IllegalArgumentException();
        }
        this.address = address;
    }


    //  Validates email address
    private boolean validateEmailAddress(String address)
    {
        return EmailValidator.getInstance(true).isValid(address);
    }


    //  Validaes phone number, checks if includes only legal characters
    private boolean validatePhoneNumber(String phone)
    {
        String regexStr = "^([0-9\\(\\)\\/\\+\\*\\-]*)$";

        return (phone.matches(regexStr));
    }


    // Validates persons name
    private  boolean validateName(String name)
    {
        String regexStr = "/^[a-z ,.'-]+$/i";

        return true;
    }
}