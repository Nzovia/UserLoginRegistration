//package com.nicholas.userloginregistration;
//
//import com.nicholas.userloginregistration.model.Roles;
//import com.nicholas.userloginregistration.repository.RoleRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)//committing the data, no rollback
//public class RoleRepositoryTests {
//    @Autowired// reference to the roleRepository
//    private RoleRepository roleRepository;
//    @Test//should be junit test
//    public void testCreateRoles(){
//        Roles users = new Roles("Users");
//        Roles admin = new Roles("Admin");
//        Roles orgAdmin = new Roles("OrgAdmin");
//
//        roleRepository.saveAll(List.of(users,admin,orgAdmin));
//        List<Roles> rolesList = roleRepository.findAll();
//        assertThat(rolesList.size()).isEqualTo(3);
//        //assertThat(rolesList.size()).isEqualTo(3);
//    }
//
//}
