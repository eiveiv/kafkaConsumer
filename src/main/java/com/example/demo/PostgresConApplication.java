package com.example.demo;

import com.example.demo.subscribers.GoalSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresConApplication {

	@Autowired
	private GoalSubscriber goalSubscriber;

	public static void main(String[] args) {
		SpringApplication.run(PostgresConApplication.class, args);
	}
}
