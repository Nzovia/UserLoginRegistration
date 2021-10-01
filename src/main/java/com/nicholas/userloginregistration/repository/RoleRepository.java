package com.nicholas.userloginregistration.repository;

import com.nicholas.userloginregistration.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

//create a role repository that extends JPA repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

}
