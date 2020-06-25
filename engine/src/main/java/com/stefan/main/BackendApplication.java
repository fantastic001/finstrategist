package com.stefan.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer {
	
	@Override
   	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        	return application.sources(BackendApplication.class);
    	}

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.sample(engine.getSession());
		SpringApplication.run(BackendApplication.class, args);
	}

}
