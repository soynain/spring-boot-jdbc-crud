package com.jdbctemplatepractice.jdbctemplatepractice;

import javax.annotation.Resource;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbctemplatepractice.jdbctemplatepractice.FileHandler.FileStorageServiceImpl;

@SpringBootApplication
public class JdbctemplatepracticeApplication implements CommandLineRunner{

	@Resource
	FileStorageServiceImpl fileStorage;
	public static void main(String[] args) {
		SpringApplication.run(JdbctemplatepracticeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		fileStorage.init();	
	}

}
