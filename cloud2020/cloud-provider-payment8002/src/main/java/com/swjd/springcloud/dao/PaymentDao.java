package com.swjd.springcloud.dao;

import com.swjd.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //保存订单方法
    Integer create(Payment payment);

    //根据id查询某个订单
    Payment findById(@Param("id") Long id);
}
