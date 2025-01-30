package com.project_final_chat_api.chatapi.repositories;

import com.project_final_chat_api.Mappers.ChannelRowMapper;
import com.project_final_chat_api.Mappers.UserRowMapper;
import com.project_final_chat_api.chatapi.entities.Channel;
import com.project_final_chat_api.chatapi.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ChannelRepositories {

    private static final String INSERT_CHANNEL  = "INSERT INTO td_channel(id,name, user_id) values(?,?,?)";
    private static final String GET_ALL_CHANNEL = "SELECT * FROM td_channel WHERE is_active=1";
    private static final String UPDATE_CHANNEL  = "UPDATE td_channel SET name=? WHERE is_active=1 AND id=?";
    private static final String DELETE_CHANNEL  = "DELETE FROM td_channel WHERE id=?";

    private final JdbcTemplate jdb;


    public ChannelRepositories(JdbcTemplate jdb) {
        this.jdb = jdb;

    }

    public boolean create(Channel channel) {

        jdb.update(INSERT_CHANNEL, channel.getId(), channel.getName(), channel.getUserId());

        return true;

    }

    public List<Channel> fetch() {

        return this.jdb.query(GET_ALL_CHANNEL.toString(), new ChannelRowMapper());

    }

    public boolean update(Channel channel) {

       int result = this.jdb.update(UPDATE_CHANNEL, channel.getName(), channel.getId(), channel.getUserId());

        if(result > 1 ) {

            throw new RuntimeException("More than one channel with same id exists");

        }

        return result == 1;

         }

    public boolean delete(int id) {

        int result = jdb.update(DELETE_CHANNEL, id);

        return result == 1;

    }





    }












