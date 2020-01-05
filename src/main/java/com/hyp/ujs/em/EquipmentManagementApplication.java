package com.hyp.ujs.em;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyp.ujs.em.mapper")
public class EquipmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentManagementApplication.class, args);
    }

}
