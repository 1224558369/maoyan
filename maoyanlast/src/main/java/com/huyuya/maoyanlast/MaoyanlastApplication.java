package com.huyuya.maoyanlast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.huyuya.maoyanlast.mapper")
public class MaoyanlastApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoyanlastApplication.class, args);
    }

}
