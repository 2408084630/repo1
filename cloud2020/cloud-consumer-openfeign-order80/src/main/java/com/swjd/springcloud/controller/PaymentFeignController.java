package com.swjd.springcloud.controller;

import com.swjd.springcloud.domain.CommonResult;
import com.swjd.springcloud.domain.Payment;
import com.swjd.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment) {
        return paymentFeignService.create(payment);
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }
}
