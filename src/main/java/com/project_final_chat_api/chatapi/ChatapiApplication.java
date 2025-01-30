package com.project_final_chat_api.chatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication (scanBasePackages = {"com.project_final_chat_api", "system.db"})
public class ChatapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatapiApplication.class, args);
	}

}
