package com.example.students.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.students.Model.User;
import com.example.students.Model.School;

class UserTest {
    @Mock
    private School mockSchool;
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
    }

    @Test
    void testGetId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    void testGetUsername() {
        user.setUsername("testUsername");
        assertEquals("testUsername", user.getUsername());
    }

    @Test
    void testGetPassword() {
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testGetFirstName() {
        user.setFirstName("testFirstName");
        assertEquals("testFirstName", user.getFirstName());
    }

    @Test
    void testGetLastName() {
        user.setLastName("testLastName");
        assertEquals("testLastName", user.getLastName());
    }

    @Test
    void testGetEmail() {
        user.setEmail("testEmail");
        assertEquals("testEmail", user.getEmail());
    }

    @Test
    void testGetSchool() {
        user.setSchool(mockSchool);
        assertEquals(mockSchool, user.getSchool());
    }
}
