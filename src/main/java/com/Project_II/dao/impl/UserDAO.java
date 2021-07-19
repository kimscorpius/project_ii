package com.Project_II.dao.impl;

import com.Project_II.dao.IUserDAO;
import com.Project_II.mapper.UserMapper;
import com.Project_II.model.User;

import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return query(sql, new UserMapper());
    }

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append("INNER JOIN userrole as ur ON u.role_id = ur.role_id ");
        sql.append("WHERE u.username = ? AND u.password = ? ");
        List<User> users = query(sql.toString(), new UserMapper(), username, password);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findByUserName(String username) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append("INNER JOIN userrole as ur ON u.role_id = ur.role_id ");
        sql.append("WHERE u.username like ? ");
        List<User> users = query(sql.toString(), new UserMapper(), username);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findByEmail(String email) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append("INNER JOIN userrole as ur ON u.role_id = ur.role_id ");
        sql.append("WHERE u.email like ? ");
        List<User> users = query(sql.toString(), new UserMapper(), email);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public boolean checkExistEmail(String email) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append("INNER JOIN userrole as ur ON u.role_id = ur.role_id ");
        sql.append("WHERE u.email like ? ");
        List<User> users = query(sql.toString(), new UserMapper(), email);
        return users.isEmpty() ? false : true;
    }

    @Override
    public boolean checkExistUsername(String username) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append("INNER JOIN userrole as ur ON u.role_id = ur.role_id ");
        sql.append("WHERE u.username like ? ");
        List<User> users = query(sql.toString(), new UserMapper(), username);
        return users.isEmpty() ? false : true;
    }

    @Override
    public Long insert(User user) {
        StringBuilder sql = new StringBuilder("INSERT INTO user(name, email, username, password, role_id, status) ");
        sql.append("VALUE(?, ?, ?, ?, ?, ?) ");
        return insert(sql.toString(), user.getName(), user.getEmail(),
                user.getUserName(), user.getPassword(), 2, 1);
    }
}
