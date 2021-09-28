package com.tct.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 资产目录
 *
 * @Author: Hannibal
 * @Date: 2021/7/1 10:59
 * @Version 1.0
 * @description
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
public class ProcessEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessEngineApplication.class, args);
        System.out.println("*********流程引擎启动成功*********");
    }

}
