package com.nicholas.userloginregistration.repository;

import com.nicholas.userloginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //this is the interface for the data access layer
    //User is the domain class, and Long is type of the ID of the domain class


}
