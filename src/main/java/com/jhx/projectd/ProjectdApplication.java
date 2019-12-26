package com.jhx.projectd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.jhx.projectd.mapper")
@SpringBootApplication
public class ProjectdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectdApplication.class, args);
    }

}
