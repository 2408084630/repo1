package com.swjd.springcloud.service;

import com.swjd.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService {
    //保存订单方法
    Integer create(Payment payment);

    //根据id查询某个订单
    Payment findById(Long id);
}
