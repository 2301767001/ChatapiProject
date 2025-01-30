package com.project_final_chat_api.chatapi.entities;

public class User {

    private int id;
    private String userName;
    private String password;
    private int isActive;

    public User(int id, String userName, String password, int isActive) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;

    }

    public User() {

    }

    public User(int id, String username, String password) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;

    }
}


