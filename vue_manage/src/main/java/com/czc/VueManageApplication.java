package com.czc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czc.*.mapper")
public class VueManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueManageApplication.class, args);
    }

}
