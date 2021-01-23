package com.swjd.springcloud.controller;

import com.swjd.springcloud.domain.CommonResult;
import com.swjd.springcloud.domain.Payment;
import com.swjd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String SERVER_PORT;

    @Resource
    private DiscoveryClient discoveryClient;

    //保存账单数据
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        Integer integer = paymentService.create(payment);
        log.info("**********插入结果********" + integer);
        if (integer > 0) {
            return new CommonResult(200,"账单保存成功,port:" + SERVER_PORT,integer);
        }else {
            return new CommonResult(444,"账单保存失败");
        }
    }

    //根据id查询账单信息
    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.findById(id);
        log.info("**********查询结果********" + payment);
        if (payment != null) {
            return new CommonResult(200,"账单查询成功,port:" + SERVER_PORT,payment);
        }else {
            return new CommonResult(444,"没有对应记录,查询失败,查询ID:" + id);
        }
    }

    //查看微服务的信息
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("#################" + service + "##############");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("####" + instance.getInstanceId() + "####" + instance.getHost() + "####" + instance.getPort() + "####" +
                    instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String lb() {
        return this.SERVER_PORT;
    }
}
