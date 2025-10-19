package com.acmud.taller1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import com.acmud.taller1.qualifiers.StoreController;
import com.acmud.taller1.qualifiers.ExperimentService;

@SpringBootApplication
public class Taller1Application implements CommandLineRunner {

    @Autowired
    @Qualifier("experimentService")
    private ExperimentService experimentService;

    @Autowired
    @Qualifier("baseBean")
    private ExperimentService baseBean;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Taller1Application.class, args);
        // Obtenemos el bean del StoreController y mostramos el descuento
        StoreController store = context.getBean(StoreController.class);
        store.showDiscount();
    }

    @Override
    public void run(String... args) {
        System.out.println("Iniciando aplicación...");
        experimentService.run();
        baseBean.run();
    }
}

