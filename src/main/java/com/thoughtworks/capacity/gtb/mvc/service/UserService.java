package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public UserService(){
        userList.add(new User("QHY","123456","12@1.com"));
    }

    public List<User> userRegister(User user){
        boolean bool = userList.stream().anyMatch(u -> u.getUsername() == user.getUsername());
        if (bool) {
            userList.add(userList.size() + 1, user);
            return userList;
        } else {
            return userList;
        }
    }

}
