package com.air.lease;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.air.lease.repository") // 包扫描
public class LeaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaseApplication.class, args);
	}

}
