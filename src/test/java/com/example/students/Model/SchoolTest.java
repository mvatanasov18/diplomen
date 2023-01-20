package com.example.students.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SchoolTest {
    @Mock
    private User mockUser;
    @Mock
    private List<User> mockUsers;
    private School school;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        school = new School();
    }

    @Test
    void testGetId() {
        school.setId(1);
        assertEquals(1, school.getId());
    }

    @Test
    void testGetName() {
        school.setName("testName");
        assertEquals("testName", school.getName());
    }

    @Test
    void testGetUsers() {
        when(mockUsers.size()).thenReturn(1);
        when(mockUsers.get(0)).thenReturn(mockUser);
        school.setUsers(mockUsers);
        assertEquals(mockUsers, school.getUsers());
    }
}