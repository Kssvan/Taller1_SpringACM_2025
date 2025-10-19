package com.acmud.taller1;

import com.acmud.taller1.ExperimentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ApplicationConfig {
    @Bean("baseBean")
    public ExperimentService baseBean(){
        System.out.println("creandoBean");
        return new ExperimentService();
    }
}
