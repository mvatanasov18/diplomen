//package com.example.students.repositories;
//
//import com.example.students.StudentsApplication;
//import com.example.students.models.Address;
//import com.example.students.models.School;
//import com.example.students.models.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = StudentsApplication.class)
//public class SchoolRepositoryTest {
//    @Autowired
//    private SchoolRepository schoolRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Test
//    public void testSaveSchool(){
//        Address address = new Address()
//                .setCity("TestCity")
//                .setStreet("testStreet")
//                .setHouseNumber(4)
//                .setAdditionalInfo("test additional info test test test тест");
//        assertNotNull(  addressRepository.save(address));
//        School school = new School()
//                .setName("TestSchool")
//                .setAddress(address);
//        assertNotNull( schoolRepository.save(school));
//        Optional<School> temp = schoolRepository.findById(school.getId());
//
//
//        schoolRepository.delete(school);
//        addressRepository.delete(address);
//    }
//}
