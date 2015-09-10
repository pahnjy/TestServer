package com.pineone.server.service;

import com.pineone.server.dao.UserDAO;
import com.pineone.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by use on 2015-09-10.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(String id) {
        userDAO.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
