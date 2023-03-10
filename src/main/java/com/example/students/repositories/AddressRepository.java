package com.example.students.repositories;

import com.example.students.models.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, String> {

}
