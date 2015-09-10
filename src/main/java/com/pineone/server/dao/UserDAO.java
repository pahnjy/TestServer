package com.pineone.server.dao;

import com.pineone.server.model.User;

import java.util.List;

/**
 * Created by use on 2015-09-10.
 */
public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    public User getUser(String id);
    public void deleteUser(String id);
    public List<User> getUsers();
}
