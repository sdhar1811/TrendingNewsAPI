package com.trendingnews.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication @ComponentScan({"com.trendingnews"})
public class TrendingNewsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendingNewsApiApplication.class, args);
	}

}
