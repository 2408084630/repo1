package com.swjd.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumerConsul/payment")
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    private String SERVER_URL = "http://cloud-payment-service";

    @GetMapping("/consul")
    public String consul() {
        return restTemplate.getForObject(SERVER_URL + "/payment/consul", String.class);
    }
}
