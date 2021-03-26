package com.webmidtermhw.controller;

import com.webmidtermhw.config.jwt.JwtUtils;
import com.webmidtermhw.dataAccessObjects.RepositoryForUser;
import com.webmidtermhw.model.Entities.User;
import com.webmidtermhw.model.dataTransferObjects.LoginModel;
import com.webmidtermhw.model.dataTransferObjects.RegistrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthWebService {
    protected static Logger log = LoggerFactory.getLogger(AuthWebService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    RepositoryForUser repositoryForUser;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    //we use post mapping for login so that we do not include password in url request
    @PostMapping("/login")
    public ResponseEntity<?> loginToWebsite(@RequestBody LoginModel loginModel){
        log.info("Login user with email: " + loginModel.getEmail());

        //authenticate user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(),  loginModel.getPassword()));

        //set this authentication
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //generate a jwt token
        String jwtToken = jwtUtils.generateJwtToken(authentication);

        //return jwt token that logged in user can use to identify themselves
        return ResponseEntity.ok(jwtToken);
    }

    //use post mapping to receive details in a secure way
    @PostMapping("/register")
    public ResponseEntity<?> registerToWebsite(@RequestBody RegistrationModel dataForm){
        log.info("registering user");
        //check if someone else has registered with this email
        if (repositoryForUser.existsByEmail(dataForm.getEmail()))
            return ResponseEntity.badRequest().body("Error: someone else has registered with this email");

        //create new user account
        User newUser = new User(dataForm);
        //encrypt password and set it for this user
        newUser.setPassword(passwordEncoder.encode(dataForm.getPassword()));

        repositoryForUser.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }
}
