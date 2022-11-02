package com.fidelity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.fidelity.integration", "com.fidelity.smallchange.controller","com.fidelity.service"})
@MapperScan(basePackages="com.fidelity.integration")  
//tell MyBatis where to scan for mapping interface files
@MapperScan(basePackages="com.fidelity.integration")  
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}

}
