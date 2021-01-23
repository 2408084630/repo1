package com.swjd.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;


    @GetMapping("/zookeeper")
    public String getZK() {
        return SERVER_PORT + "********" + UUID.randomUUID().toString();
    }
}
