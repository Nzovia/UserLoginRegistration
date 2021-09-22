package com.nicholas.userloginregistration;

import com.nicholas.userloginregistration.model.User;
import com.nicholas.userloginregistration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest// indicate that it is running as JPA test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//using real db
@Rollback(value = false) // no rolling back the transactions
public class UserRepositoryTests {
    //in this class we test data access layer(Repository Interface)
    @Autowired//to test user repository CRUD operations
    private UserRepository repository;
    @Autowired//to access the provided testmanager class by the SpringJPA used to perform assertion
    private TestEntityManager entityManager;

    //perform the firstTest, creating new users
    @Test
    public void testCreatUser(){
        User user = new User();
        user.setFirstName("Nicholas");
        user.setSecondName("Maundu");
        user.setEmail("nichonzovia@gmail.com");
        user.setPassword("123$Nick");

        //perform the CRUD operation save of the userRepository interface
       User savedUser = repository.save(user);
       //then to assert this test method we use entity manager
       User existsUser = entityManager.find(User.class, savedUser.getId());// find entity by its primaryKey
       //using the primary key get the user email to affirm it is as expected for the existing user
       assertThat(existsUser.getEmail()).isEqualTo(user.getEmail());

    }
    @Test
    public  void testFindUserByEmail(){
        String email = "nichon@gmail.com";
        User user= repository.findByEmail(email);
        assertThat(user).isNotNull();

    }
}
