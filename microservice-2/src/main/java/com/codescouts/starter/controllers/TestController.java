package com.codescouts.starter.controllers;

import com.codescouts.starter.domain.Test;
import com.codescouts.starter.services.RabbitReceiver;
import com.codescouts.starter.services.RedisService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RabbitReceiver rabbitReceiver;

    @GetMapping("/test/{id}")
    public ResponseEntity<Test> get(@PathVariable Long id) {
        Test test = this.redisService.get(id);

        return ResponseEntity.ok(test);
    }

    @PostMapping("/test")
    public ResponseEntity<Test> set(@RequestBody Test test) {
        this.redisService.set(test);

        return ResponseEntity.ok(test);
    }

    @GetMapping("/test/rabbit")
    public @ResponseBody List<String> getFromRabbit() {
        return this.rabbitReceiver.getMessages();
    }

}
