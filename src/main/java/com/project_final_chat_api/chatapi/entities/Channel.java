package com.project_final_chat_api.chatapi.entities;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private int id;
    private String name;
    private int userId;

    private List<Message.Mеssage> mеssages = new ArrayList<>() ;

    public Channel(int id, String name, int userId) {
        this.id         = id;
        this.name       = name;
        this.userId     = userId;

    }

    public Channel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    }


