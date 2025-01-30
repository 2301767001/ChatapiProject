package com.project_final_chat_api.Mappers;

import com.project_final_chat_api.chatapi.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

       User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));

        return user;

    }
}
