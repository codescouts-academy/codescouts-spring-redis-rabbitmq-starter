package com.codescouts.starter.controllers;

import com.codescouts.starter.domain.Test;
import com.codescouts.starter.services.RedisService;
import com.codescouts.starter.services.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Test podemos hacer commit
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RabbitSender rabbitSender;

    @GetMapping("/test/{id}")
    public ResponseEntity<Test> getFromRedis(@PathVariable Long id) {
        Test test = this.redisService.get(id);

        return ResponseEntity.ok(test);
    }

    @PostMapping("/test")
    public ResponseEntity<Test> setToRedis(@RequestBody Test test) {
        this.redisService.set(test);

        return ResponseEntity.ok(test);
    }

    @PostMapping("/test/rabbit")
    public ResponseEntity<Test> sendWithRabbit(@RequestBody Test test) {
        this.rabbitSender.send(test);

        return ResponseEntity.ok(test);
    }
}
