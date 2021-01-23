package com.swjd.springcloud.controller;

import com.swjd.springcloud.domain.CommonResult;
import com.swjd.springcloud.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumerZK/payment")
public class OrderController {

    public static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public String create() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zookeeper",String.class);
    }
}
