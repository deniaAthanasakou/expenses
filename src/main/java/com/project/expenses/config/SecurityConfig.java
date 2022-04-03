package com.project.expenses.config;

import com.project.expenses.entities.User;
import com.project.expenses.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static Logger LOGGER = Logger.getLogger(SecurityConfig.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CustomPasswordEncoder customPasswordEncoder(){
        return new CustomPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        ///categories url needs user with role REPORTER to be accessed. Other urls are accessed by everyone
        http.csrf().disable()
                .authorizeRequests().antMatchers("/").access("hasRole('REPORTER')")
                .antMatchers("/**").permitAll().and()
                .formLogin().loginPage("/login").permitAll()
                .failureUrl("/login?error=true");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //this works
        /*auth.inMemoryAuthentication()
                .withUser("test").password("{noop}test").roles("REPORTER");*/
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)
                    throws UsernameNotFoundException {
                User userDetails = userRepository.findById(username).orElse(null);
                if (userDetails != null) {
                    LOGGER.info("User " + username + " will log in. Fullname is " + userDetails.getFullname());
                    return userDetails;
                }
                throw new UsernameNotFoundException("User '" + username + "' not found.");
            }
        }).passwordEncoder(customPasswordEncoder());
    }
}
