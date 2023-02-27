package com.example.students.repositories;

import com.example.students.StudentsApplication;
import com.example.students.models.Address;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.services.PasswordHasher;
import com.example.students.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentsApplication.class)
public class UserRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void testSaveUser() {
        Address address = new Address()
                .setCity("TestCity")
                .setStreet("testStreet")
                .setHouseNumber(4)
                .setAdditionalInfo("test additional info test test test тест");
        assertNotNull(addressRepository.save(address));

        School school = new School()
                .setName("TestSchool")
                .setAddress(address);
        assertNotNull(schoolRepository.save(school));

        User user = new User()
                .setEmail("test@test.com")
                .setFirstName("Test")
                .setLastName("Testov")
                .setPassword("VeryStrongPassword123")
                .setUsername("testUser")
                .setSchool(school);
        assertNotNull(userRepository.save(user));

        Optional<User> temp = userRepository.findById(user.getId());
        assertTrue(temp.isPresent());

        assertEquals(temp.get().getId(), user.getId());
        assertEquals(temp.get().getPassword(), PasswordHasher.hashPassword("VeryStrongPassword123"));
        assertEquals(temp.get().getEmail(), user.getEmail());
        assertEquals(temp.get().getFirstName(), user.getFirstName());
        assertEquals(temp.get().getLastName(), user.getLastName());
        assertEquals(temp.get().getSchool(), user.getSchool());
        assertEquals(temp.get().getUsername(), user.getUsername());
        assertNotEquals(temp.get().getPassword(), PasswordHasher.hashPassword("test123"));
        userRepository.delete(user);
        schoolRepository.delete(school);
        addressRepository.delete(address);
    }
}
