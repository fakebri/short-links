package com.bri.shortlinks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.bri.shortlinks.dao")
@EnableWebMvc
public class ShortlinksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortlinksApplication.class, args);
	}

}
