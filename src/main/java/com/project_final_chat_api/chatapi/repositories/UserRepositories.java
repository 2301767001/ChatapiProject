package com.project_final_chat_api.chatapi.repositories;

import com.project_final_chat_api.Mappers.UserRowMapper;
import com.project_final_chat_api.chatapi.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositories {

    private static final String INSERT_USER = "INSERT INTO td_users(userName,password) values(?,?)";
    private static final String GET_ALL_USER = "SELECT * FROM td_users WHERE is_active=1";
    private static final String UPDATE_USER = "UPDATE td_users SET userName=?,password=? WHERE is_active=1 AND id=?";
    private static final String DELETE_USER = "DELETE FROM td_users WHERE id=?";


    private final JdbcTemplate jdb;

    public UserRepositories(JdbcTemplate jdb) {
        this.jdb = jdb;
    }


    public boolean create(User user) {

        jdb.update(INSERT_USER, user.getUserName(), user.getPassword());

        return true;

    }

    public List<User> fetchAll() {

      return this.jdb.query(GET_ALL_USER.toString(), new UserRowMapper());

    }

        public User fetchSingle(int id) {


            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM td_users WHERE is_active = 1 AND id =" + id);

            ArrayList<User> collection = (ArrayList<User>) this.jdb.query(query.toString(), new UserRowMapper());

              if(collection.isEmpty())
                  return null;

              return collection.get(0);

        }

        public boolean update(User user) {

       int result = jdb.update(UPDATE_USER, user.getUserName(), user.getPassword(), user.getId());

       if(result > 1) {

           throw new RuntimeException("More than one user with same id exists");

       }

       return result == 1;

        }

        public boolean delete(int id) {

        int result = jdb.update(DELETE_USER, id);

        return result == 1;

        }

    }






