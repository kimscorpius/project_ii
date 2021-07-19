package com.Project_II.dao;

import com.Project_II.model.User;

import java.util.List;

public interface IUserDAO extends GenericDAO<User> {

    List<User> findAll();

    User findByUserNameAndPassword(String userName, String password);

    User findByUserName(String username);

    User findByEmail(String email);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    Long insert(User user);
}
