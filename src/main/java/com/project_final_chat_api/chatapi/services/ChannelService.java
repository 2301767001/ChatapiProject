package com.project_final_chat_api.chatapi.services;

import com.project_final_chat_api.chatapi.entities.Channel;
import com.project_final_chat_api.chatapi.entities.User;
import com.project_final_chat_api.chatapi.repositories.ChannelRepositories;
import com.project_final_chat_api.chatapi.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private ChannelRepositories channelRepositories;
    private UserRepositories userRepositories;


    public ChannelService(ChannelRepositories channelRepositories, UserRepositories userRepositories) {
        this.channelRepositories = channelRepositories;
        this.userRepositories = userRepositories;

    }

    public boolean createChannel(Channel channel) {

        return this.channelRepositories.create(channel);

    }

    public List<Channel> getChannel() {

       return this.channelRepositories.fetch();

    }

    public boolean updateChannel(Channel channel) {

       return this.channelRepositories.update(channel);

    }

    public boolean removeChannel(int id) {

        return this.channelRepositories.delete(id);

    }

    }











