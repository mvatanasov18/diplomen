//package com.example.students.repositories;
//
//import com.example.students.StudentsApplication;
//import com.example.students.models.Address;
//import com.example.students.models.Admin;
//import com.example.students.models.School;
//import com.example.students.models.User;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = StudentsApplication.class)
//public class AdminRepositoryTest {
//    @Autowired
//    private AdminRepository adminRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private SchoolRepository schoolRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//
//    private Admin admin;
//    private Address address;
//    private School school;
//    private User user;
//
//    @Test
//    @Order(1)
//    public boolean setUp() {
//         address = new Address()
//                .setCity("TestCity")
//                .setStreet("testStreet")
//                .setHouseNumber(4)
//                .setAdditionalInfo("test additional info test test test тест");
//        assertNotNull(  addressRepository.save(address));
//         school = new School()
//                .setName("TestSchool")
//                .setAddress(address);
//        assertNotNull( schoolRepository.save(school));
//        user = new User()
//                .setEmail("test@test.com")
//                .setFirstName("Test")
//                .setLastName("Testov")
//                .setPassword("VeryStrongPassword123")
//                .setUsername("testUser")
//                .setSchool(school);
//
//        assertNotNull(userRepository.save(user));
//        admin = new Admin().setUser(user);
//
//        return true;
//    }
//
//    @Test
//    @Order(2)
//    public void testSaveAdmin() {
//        if (setUp()) {
//            Admin temp = adminRepository.save(admin);
//            assertNotNull(temp);
//            System.out.println(temp);
//            adminRepository.delete(admin);
//            userRepository.delete(user);
//            schoolRepository.delete(school);
//            addressRepository.delete(address);
//        }
//    }
//}
