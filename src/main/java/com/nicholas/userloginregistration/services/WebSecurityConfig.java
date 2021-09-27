package com.nicholas.userloginregistration.services;

//This file is well Commented to explain every aspect of spring security authentication
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; //connect user database for authentication
    @Bean // for user details service class
    public UserDetailsService userDetailsService(){
        return new  CustomUserDetailsService();
    }
    @Bean //for password enconder
    public BCryptPasswordEncoder passwordEncoder(){
        //bYCrypt recommended since it provides better and strong password encording
        return new BCryptPasswordEncoder();

    }
    @Bean//for DAO Authentication provider
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        //here set the authentication details
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
   /*Note: to configure spring security we need to override several methods,
    Configure(HTTpSecurity, AuthenticationManagerBuilder and in it set
    authentication provider for the auth object of the authenticationProviderMethod)
   */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider()); //configure authenticationProvider object of the
        // authenticationProvider method
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //here in configure http we configure the log in and log out for the application
        http.authorizeRequests()
                //list all the users registered on the website, there we use antmatchers to match with the url
                .antMatchers("/users").authenticated()
                //. authenticated means for you to view this page
                // you have to be authenticated since it is protected by spring security
                .anyRequest().permitAll()
                .and()
                // configuring to the login page we used before or provided by spring security
                .formLogin()
                     .usernameParameter("email")
                     //landing page for the user on successful login
                     .defaultSuccessUrl("/users")
                     .permitAll()
                //implementing logout
                .and()
                .logout().logoutSuccessUrl("/").permitAll();



    }
}
