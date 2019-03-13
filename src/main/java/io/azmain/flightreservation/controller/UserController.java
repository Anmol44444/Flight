package io.azmain.flightreservation.controller;


import io.azmain.flightreservation.entities.User;
import io.azmain.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam("email") String email,
                          @RequestParam("password") String password){
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            return null;
        }
    }
}
