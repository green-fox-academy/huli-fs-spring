package com.greenfox.hulispring.controllers;

import com.greenfox.hulispring.models.Data;
import com.greenfox.hulispring.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

  @Autowired
  MessageRepo messageRepo;

  @GetMapping (value = "/hello")
  public Data hello() {
    return new Data(messageRepo.findAll(), "ok");
  }
}
