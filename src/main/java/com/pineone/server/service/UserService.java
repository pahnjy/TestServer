package com.pineone.server.service;

import com.pineone.server.model.User;

import java.util.List;

/**
 * Created by use on 2015-09-10.
 */
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    User getUser(String id);
    void deleteUser(String id);
    List<User> getUsers();
}
