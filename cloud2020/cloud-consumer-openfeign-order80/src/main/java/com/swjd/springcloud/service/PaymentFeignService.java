package com.swjd.springcloud.service;

import com.swjd.springcloud.domain.CommonResult;
import com.swjd.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {

    //保存账单数据
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment);


    //根据id查询账单信息
    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);
}
