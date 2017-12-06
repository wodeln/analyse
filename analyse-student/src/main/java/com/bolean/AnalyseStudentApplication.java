package com.bolean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bolean.dao")
public class AnalyseStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyseStudentApplication.class, args);
	}
}
