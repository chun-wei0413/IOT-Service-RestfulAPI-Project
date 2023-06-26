package com.example.Fproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Fproject.database.DatabaseService;
@SpringBootApplication
public class FprojectApplication {
	@Autowired
	private  DatabaseService databaseService;
	public static void main(String[] args) {

		SpringApplication.run(FprojectApplication.class, args);
	}
	//12345
}
