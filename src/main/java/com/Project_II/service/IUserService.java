package com.Project_II.service;

import com.Project_II.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean register(String name, String email, String username, String password);

    User findByUserNameAndPassword(String userName, String password);
}
