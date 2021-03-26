package com.webmidtermhw.services.implementation;

import com.webmidtermhw.dataAccessObjects.RepositoryForUser;
import com.webmidtermhw.model.Entities.User;
import com.webmidtermhw.model.Entities.implementation.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//here we implement the spring security  UserDetailService
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    RepositoryForUser repositoryForUser;

    //here since we want to login with email, we'll use email as username
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repositoryForUser.findByEmail(email);
        return UserDetailsImpl.build(user);
    }
}
