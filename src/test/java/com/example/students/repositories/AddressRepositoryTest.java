package com.example.students.repositories;

import com.example.students.StudentsApplication;
import com.example.students.models.Address;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentsApplication.class)
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository repository;


    @Test
    public void testSaveAddress() {

        Address address = new Address();
        address.setCity("New York");
        address.setStreet("Broadway");
        address.setHouseNumber(123);
        address.setAdditionalInfo("Apartment 456");

        assertEquals(repository.save(address),address);
        repository.delete(address);
    }

    @Test
    public void testSaveAddressWithCyrillic(){
        Address address = new Address();
        address.setCity("Бургас");
        address.setStreet("Иван Вазов");
        address.setHouseNumber(7);
        address.setAdditionalInfo("до съседите");
        assertEquals(repository.save(address), address);
    }
}
