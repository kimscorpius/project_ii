package com.Project_II.service.impl;

import com.Project_II.dao.IUserDAO;
import com.Project_II.dao.impl.UserDAO;
import com.Project_II.model.User;
import com.Project_II.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDAO userDAO = new UserDAO();

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDAO.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDAO.checkExistUsername(username);
    }

    @Override
    public boolean register(String name, String email, String username, String password) {
        if (userDAO.checkExistUsername(username) || userDAO.checkExistEmail(email)) {
            return false;
        }
        userDAO.insert(new User(name, email, username, password));
        return true;
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userDAO.findByUserNameAndPassword(userName, password);
    }
}
