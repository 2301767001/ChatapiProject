package com.project_final_chat_api.chatapi.controllers;

import com.project_final_chat_api.chatapi.entities.User;
import com.project_final_chat_api.chatapi.http.AppResponse;
import com.project_final_chat_api.chatapi.services.ChannelService;
import com.project_final_chat_api.chatapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UserController {

    private UserService userService;
    private ChannelService channelService;

    public UserController(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;


    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        HashMap<String, Object> response = new HashMap<>();

        if (this.userService.createUser(user)) {

            return AppResponse.success()
                    .withMassage("User create Successful ")
                    .build();

        }

        return AppResponse.error()
                .withMassage("User could not be created")
                .build();

    }

    @GetMapping("/users")
    public ResponseEntity<?> fetchAllUser() {

      ArrayList<User> collection = (ArrayList<User>) this.userService.getAllUsers();

            return AppResponse.success().withDataArray(collection).build();

        }

          @GetMapping("/users/{id}")
         public ResponseEntity<?> fetchSingleUser(@PathVariable("id") int id) {

            User user = this.userService.getSingle(id);

           if (user == null) {

          return AppResponse.error().withMassage("User not found").build();

           }

         return AppResponse.success().withDataArray(user).build();

          }

          @PutMapping("/users")
          public ResponseEntity<?> updateUser(@RequestBody User user) {

          boolean UpdateSuccessful = this.userService.updateUser(user);

          if (UpdateSuccessful) {

           return AppResponse.success().withMassage("User update Successful").build();

         }

         return AppResponse.success().withMassage("User not data error").build();

        }

         @DeleteMapping("/users/{id}")
         public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
          this.userService.removeUser(id);

          boolean DeleteSuccessful = this.userService.removeUser(id);

         if(DeleteSuccessful) {
           return AppResponse.success().withMassage("User delete Successful").build();

         }

          return AppResponse.success().withMassage("User not delete").build();

         }

         }



