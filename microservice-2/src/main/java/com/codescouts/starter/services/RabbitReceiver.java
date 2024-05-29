package com.codescouts.starter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitReceiver {

  private List<String> messages = new ArrayList<>();

  @Autowired
  private AmqpTemplate amqpTemplate;

  @RabbitListener(queues = "my.queue")
  public void watchQueue(String message) {
    System.out.println("Processing message: " + message);
    this.messages.add(message);
  }

  public List<String> getMessages() {
    return this.messages;
  }
}
