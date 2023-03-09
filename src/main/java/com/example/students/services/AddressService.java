package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements com.example.students.services.Service<Address> {
    private final AddressRepository addressRepository;

    public Address save(Address address){
        return addressRepository.save(address);
    }
    public void delete(Address address){
        addressRepository.delete(address);
    }
    public Address findById(String id){
        return addressRepository.findById(id).orElse(null);
    }
    public Iterable<Address> findAll(){
        return addressRepository.findAll();
    }
}
