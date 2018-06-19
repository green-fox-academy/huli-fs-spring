package com.greenfox.hulispring.repositories;

import com.greenfox.hulispring.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageRepo extends CrudRepository <Message,Long> {

  List<Message> findAll();

}
