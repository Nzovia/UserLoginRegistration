package com.nicholas.userloginregistration.repository;

import com.nicholas.userloginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    //this is the interface for the data access layer
    //User is the domain class, and Long is type of the ID of the domain class
    @Query("SELECT u FROM User u WHERE u.email = ?1")
     User findByEmail(String email);

}
