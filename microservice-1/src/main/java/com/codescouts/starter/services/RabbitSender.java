package com.codescouts.starter.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codescouts.starter.domain.Test;

@Service
public class RabbitSender {

  @Autowired
  private AmqpTemplate amqpTemplate;

  public void send(Test test) {
    String message = "Message: "+ test.id + " " + test.value;

    amqpTemplate.convertAndSend("my.exchange", "my.queue", message);
  }
}