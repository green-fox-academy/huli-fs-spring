package com.greenfox.hulispring;

import com.greenfox.hulispring.models.Message;
import com.greenfox.hulispring.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HulispringApplication implements CommandLineRunner {

  @Autowired
  MessageRepo messageRepo;

  @Autowired
  LocalFileSystemOperator localFileSystemOperator;

	public static void main(String[] args) {

        SpringApplication.run(HulispringApplication.class, args);
    }

  @Override
  public void run(String... args) throws Exception {
     localFileSystemOperator.createFile("FILENAME.txt");
  }
}
