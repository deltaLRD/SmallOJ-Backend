package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.Pong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping(value = "/api/ping", produces = "application/json;charset=UTF-8")
    public Pong Ping() {
        Pong resp = new Pong();
        resp.setStr("Pong");
        return resp;
    }
}
