package com.example.students.controllers;

import com.example.students.models.Address;
import com.example.students.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AddressRepository repository;

    @GetMapping(value = "/")
    public String getIndex(){
//        Address address = new Address();
//        address.setCity("New York");
//        address.setStreet("Broadway");
//        address.setHouseNumber(123);
//        address.setAdditionalInfo("Apartment 456");
//        Address savedAddress = repository.save(address);
//        System.out.println(address);
//        System.out.println("saved address: ");
//        System.out.println(savedAddress);
        return "index";
    }
    @GetMapping(value="/register")
    public String getRegister(){
        return "register";
    }

}
