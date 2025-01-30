package com.project_final_chat_api.chatapi.services;

import com.project_final_chat_api.chatapi.entities.User;
import com.project_final_chat_api.chatapi.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;

    }

    public boolean createUser(User user) {

        return this.userRepositories.create(user);

    }

    public List<User> getAllUsers() {

        return this.userRepositories.fetchAll();

    }

    public User getSingle(int id) {

       return this.userRepositories.fetchSingle(id);

     }

     public boolean updateUser(User user) {

        return this.userRepositories.update(user);

     }

     public boolean removeUser(int id) {

        return this.userRepositories.delete(id);

     }

     }




