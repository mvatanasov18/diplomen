package com.example.students.repositories;

import com.example.students.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET FirstName= :firstName, LastName=:lastName, Username=:username, Email=:email WHERE Id=:id",nativeQuery = true)
    void update(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("username") String username,
            @Param("email") String email,
            @Param("id") String id);

    User findByEmail(String email);
}
