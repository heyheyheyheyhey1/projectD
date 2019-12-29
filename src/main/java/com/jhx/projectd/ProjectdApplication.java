package com.jhx.projectd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jhx.projectd.mapper")
@SpringBootApplication
public class ProjectdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectdApplication.class, args);
    }

}
