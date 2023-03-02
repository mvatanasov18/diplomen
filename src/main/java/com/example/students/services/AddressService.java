package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
    public void deleteAddress(Address address){
        addressRepository.delete(address);
    }
    public Address findById(String id){
        return addressRepository.findById(id).orElse(null);
    }
    public Iterable<Address> findAll(){
        return addressRepository.findAll();
    }
}
