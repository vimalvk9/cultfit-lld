package com.company.dao;

import com.company.entity.User;

import java.util.*;

public class UserDAO {

    private HashMap<String, User> userMap = new HashMap<>();
    public void addUser(User user) {
        userMap.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return userMap.getOrDefault(email, null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public Boolean isValidUser(String email) {
        User user = getUser(email);
        return Objects.nonNull(user);
    }

}
