package com.example.students.repositories;

import com.example.students.StudentsApplication;
import com.example.students.models.Address;
import com.example.students.models.School;
import com.example.students.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentsApplication.class)
public class AdminRepositoryTest {
    @Autowired
    private AdminRepository repository;

    @Test
    private void testSaveAdmin(){
        Address address=mock(Address.class);


        School school = mock(School.class);
when(school.getName()).thenReturn("TestSchool");
when(school.getId()).thenReturn(UUID.randomUUID().toString());
//when(school.getAddress()).thenReturn()

        User user =mock(User.class);
        when(user.getId()).thenReturn(UUID.randomUUID().toString());
        when(user.getEmail()).thenReturn("test@test.com");
        when(user.getFirstName()).thenReturn("Test");
        when(user.getLastName()).thenReturn("Testov");
        when(user.getPassword()).thenReturn("VeryStrongPassword123");
        when(user.getUsername()).thenReturn("testUser");
        //when(user.getSchool()).thenReturn()

    }
}
