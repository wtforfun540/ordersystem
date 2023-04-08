package com.shoom.ordersystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.shoom.ordersystem.mapper"})
public class MyBatisConfig {
}
