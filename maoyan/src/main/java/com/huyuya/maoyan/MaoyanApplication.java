package com.huyuya.maoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.huyuya.maoyan.mapper")
public class MaoyanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanApplication.class, args);
    }

}
