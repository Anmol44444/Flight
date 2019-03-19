package io.azmain.flightreservation.controller;


import io.azmain.flightreservation.entities.User;
import io.azmain.flightreservation.repos.UserRepository;
import io.azmain.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam("email") String email,
                          @RequestParam("password") String password){
        LOGGER.error("ERROR");
        LOGGER.warn("WARN");
        LOGGER.info("INFO");
        LOGGER.debug("DEBUG");
        LOGGER.trace("TRACE");
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            return null;
        }

       /*boolean loginResponse = securityService.login(email,password);
        if(loginResponse){
            return userRepository.findByEmail(email);
        }
        else{
            return null;
        }*/
    }
}
