package com.acmud.taller1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.acmud.taller1.qualifiers.StoreController;

@SpringBootApplication
public class Taller1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Taller1Application.class, args);

        // Obtenemos el bean del StoreController
        StoreController store = context.getBean(StoreController.class);
        store.showDiscount();
    }
}
