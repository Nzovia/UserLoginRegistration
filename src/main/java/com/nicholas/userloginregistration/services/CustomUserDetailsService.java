package com.nicholas.userloginregistration.services;

import com.nicholas.userloginregistration.CustomUserDetails;
import com.nicholas.userloginregistration.model.User;
import com.nicholas.userloginregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    //pass an object of userRepository
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw  new UsernameNotFoundException("user not found");
        }
        return new CustomUserDetails(user);
    }
}
