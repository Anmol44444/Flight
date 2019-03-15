package io.azmain.flightreservation.controller;


import io.azmain.flightreservation.entities.User;
import io.azmain.flightreservation.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
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
    }
}
