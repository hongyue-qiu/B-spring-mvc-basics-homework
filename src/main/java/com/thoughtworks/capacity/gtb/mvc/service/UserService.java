package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.excption.NameNotUniqueException;
import com.thoughtworks.capacity.gtb.mvc.excption.NameOrPasswordException;
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

    public List<User> userRegister(User user) throws NameNotUniqueException {
        boolean bool = userList.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));
        if (!bool) {
            userList.add(user);
            return userList;
        } else {
            throw new NameNotUniqueException("name not unique");
        }
    }

    public User userLogin(User user) throws NameOrPasswordException {
        User loginUser = userList.stream()
                .filter(u-> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
                .findAny().orElse(null);
        if (loginUser == null) throw new NameOrPasswordException("用户名或密码错误");
        return loginUser;
    }


}
