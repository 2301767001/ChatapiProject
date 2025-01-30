package com.project_final_chat_api.Mappers;

import com.project_final_chat_api.chatapi.entities.Channel;
import com.project_final_chat_api.chatapi.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChannelRowMapper  implements RowMapper<Channel> {

    @Override
    public Channel mapRow(ResultSet rs, int rowNum) throws SQLException {

        Channel channel = new Channel();
        channel.setId(rs.getInt("id"));
        channel.setName(rs.getString("name"));
        channel.setUserId(rs.getInt("user_id"));

        return channel;

    }


}
