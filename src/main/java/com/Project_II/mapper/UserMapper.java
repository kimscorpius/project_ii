package com.Project_II.mapper;

import com.Project_II.model.User;
import com.Project_II.model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            Long id = resultSet.getLong("id");
            user.setId(id.intValue());
            user.setName(resultSet.getString("name"));
            user.setUserName(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setRoleId(resultSet.getInt("role_id"));
            user.setStatus(resultSet.getInt("status"));
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
