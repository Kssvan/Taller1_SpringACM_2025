package com.acmud.taller1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Taller1Application implements CommandLineRunner{

	@Autowired
	@Qualifier("experimentService")
	private ExperimentService experimentService; 
    
	@Autowired
	@Qualifier("baseBean")
	private ExperimentService baseBean; 

	@Override 
	public void run(String... args){
		System.out.println("iniciando");
		experimentService.run();
		baseBean.run();

	}
	public static void main(String[] args) {
		SpringApplication.run(Taller1Application.class, args);
	}

}
