package com.air.lease;

<<<<<<< HEAD
=======
import org.mybatis.spring.annotation.MapperScan;
>>>>>>> b9d553927d9ad20a99dda1a6f1ea986e056412de
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD
=======
@MapperScan("com.air.lease.repository") // 包扫描
>>>>>>> b9d553927d9ad20a99dda1a6f1ea986e056412de
public class LeaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaseApplication.class, args);
	}

}
