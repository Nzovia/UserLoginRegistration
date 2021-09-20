package com.nicholas.userloginregistration.repository;

import com.nicholas.userloginregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
