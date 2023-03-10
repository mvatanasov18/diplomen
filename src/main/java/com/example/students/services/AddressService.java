package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService implements com.example.students.services.Service<Address> {
    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address findById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }
}
