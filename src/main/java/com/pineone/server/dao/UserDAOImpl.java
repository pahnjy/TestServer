package com.pineone.server.dao;

import com.pineone.server.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by use on 2015-09-10.
 */
@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch ( HibernateException he ) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setId(user.getId());
        userToUpdate.setUid(user.getUid());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setSex(user.getSex());
        userToUpdate.setName(user.getName());

        userToUpdate.setEmail(user.getEmail());
        getCurrentSession().update(userToUpdate);
    }

    @Override
    public User getUser(String id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        User user = getUser(id);
        if (user != null)
        {
            getCurrentSession().delete(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }
}
