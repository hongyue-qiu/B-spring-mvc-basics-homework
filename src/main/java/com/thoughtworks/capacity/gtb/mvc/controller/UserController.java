package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.excption.NameNotUniqueException;
import com.thoughtworks.capacity.gtb.mvc.excption.NameOrPasswordException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    public User getUser(@RequestParam("username") @Valid String username ,
                        @RequestParam("password") @Valid String password) throws NameOrPasswordException {
        return userService.userLogin(new User(username,password));
    }

}
