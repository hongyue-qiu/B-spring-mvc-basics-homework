package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.excption.NameNotUniqueException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid User user) throws NameNotUniqueException {
        userService.userRegister(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@RequestParam("username") String username ,@RequestParam("password") String password){
        return userService.userLogin(new User(username,password));
    }

}
