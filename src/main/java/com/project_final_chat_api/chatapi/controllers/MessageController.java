package com.project_final_chat_api.chatapi.controllers;


import com.project_final_chat_api.chatapi.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/messages")
    @SendTo("channel/public")
    public Message receivePublicMessage(@Payload Message message) {

        return message;

    }

    @MessageMapping("/private-messages")
    public Message receivePrivateMessage(@Payload Message message) {

        simpMessagingTemplate.convertAndSend(message);

        return message;
    }




}
