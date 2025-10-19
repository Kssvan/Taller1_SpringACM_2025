package com.acmud.taller1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Configuration 
public class ApplicationConfig {
    @Bean("baseBean")
    public BaseBean baseBean(){
        System.out.println("creandoBean");
        return new BaseBean();
    }
}
