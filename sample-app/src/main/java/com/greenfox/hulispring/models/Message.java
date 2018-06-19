package com.greenfox.hulispring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;
  private String text;

  public Message(String text) {
    this.text = text;
  }

  public Message() {
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
