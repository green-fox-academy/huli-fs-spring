package com.greenfox.hulispring.models;

import java.util.List;

public class Data {

  private String status;
  private List<Message> messages;

  public Data(List<Message> messages, String status) {
    this.status = status;
    this.messages = messages;
  }

  public Data(String status) {
    this.status = status;
  }

  public Data() {
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
