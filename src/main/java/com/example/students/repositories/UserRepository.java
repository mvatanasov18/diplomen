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
    @Query(value = "UPDATE Users SET Username= :username WHERE Id=:id;",nativeQuery = true)
    void updateUsername(String username,String id);
    @Query(value = "UPDATE Users SET Email= :email WHERE Id=:id;",nativeQuery = true)
    void updateEmail(String email,String id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET FirstName= :firstName, LastName=:lastName WHERE Id=:id",nativeQuery = true)
    void update(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("id") String id);
}
