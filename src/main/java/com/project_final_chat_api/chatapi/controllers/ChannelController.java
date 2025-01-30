package com.project_final_chat_api.chatapi.controllers;

import com.project_final_chat_api.chatapi.entities.Channel;
import com.project_final_chat_api.chatapi.entities.User;
import com.project_final_chat_api.chatapi.http.AppResponse;
import com.project_final_chat_api.chatapi.services.ChannelService;
import com.project_final_chat_api.chatapi.services.MessageService;
import com.project_final_chat_api.chatapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ChannelController {

    private ChannelService channelService;
    private UserService    userService;
    private MessageService messageService;

    public ChannelController(ChannelService channelService, UserService userService, MessageService messageService) {
        this.channelService = channelService;
        this.userService    = userService;
        this.messageService = messageService;

    }


    @PostMapping("/channels")
    public ResponseEntity<?> createNewChannel(@RequestBody Channel channel) {
        HashMap<String, Object> response = new HashMap<>();

        if (this.channelService.createChannel(channel)) {

            return AppResponse.success()
                    .withMassage("Channel create Successful ")
                    .build();

        }

        return AppResponse.error()
                .withMassage("Channel could not be created")
                .build();

    }


    @GetMapping("/channels")
    public ResponseEntity<?> getAllChannel() {

        ArrayList<Channel> channel = (ArrayList<Channel>) this.channelService.getChannel();

        return AppResponse.success().withDataArray(channel).build();

    }

    @PutMapping("/channels")
    public ResponseEntity<?> updateNewChannel(@RequestBody Channel channel) {

        this.channelService.updateChannel(channel);

        return AppResponse.success().withMassage("Channel update Successful").build();

    }

    @DeleteMapping("/channels/{id}")
    public ResponseEntity<?> deleteChannel(@PathVariable("id") int id) {

        boolean DeleteChannel = this.channelService.removeChannel(id);

        if(DeleteChannel) {

            return AppResponse.success().withMassage("Channel delete Successful").build();
        }

        return AppResponse.error().withMassage("Channel not delete").build();

    }

    @GetMapping("/channels/users/{id}")
    public ResponseEntity<?> fetchUserToChannel(@PathVariable("id") int id) {

        User user = this.userService.getSingle(id);

        if(user == null) {

            return AppResponse.error().withMassage("User not found").build();

        }

        return AppResponse.success().withDataArray(user).build();

    }




    }







