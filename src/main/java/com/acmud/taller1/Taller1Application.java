package com.acmud.taller1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import com.acmud.taller1.qualifiers.StoreController;
import com.acmud.taller1.clonesContenedor.ProductServiceDynamic;
import com.acmud.taller1.clonesContenedor.ProductServiceShared;
import com.acmud.taller1.clonesContenedor.ShoppingCart;
import com.acmud.taller1.qualifiers.ExperimentService;

@SpringBootApplication
public class Taller1Application implements CommandLineRunner {

    @Autowired
    @Qualifier("experimentService")
    private ExperimentService experimentService;

    @Autowired
    @Qualifier("baseBean")
    private ExperimentService baseBean;

    @Autowired
    private ApplicationContext context;

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

        System.out.println("\n=============================");
        System.out.println("PUNTO 2 LOS CLONES DEL CONTENEDOR");
        System.out.println("=============================");

        //  Escenario 1 — Carrito compartido (error)
        System.out.println("\n Escenario 1: Inyección directa (carrito compartido)");

        ProductServiceShared shared1 = context.getBean(ProductServiceShared.class);
        ProductServiceShared shared2 = context.getBean(ProductServiceShared.class);

        shared1.addItem("Laptop");
        shared2.addItem("Celular");

        System.out.println("Carrito desde ProductService 1: " + shared1.getCart());
        System.out.println("Carrito desde ProductService 2: " + shared2.getCart());

        //  Escenario 2 — Solución con ObjectProvider
        System.out.println("\n Escenario 2: Uso de ObjectProvider (carritos individuales)");

        ProductServiceDynamic dynamic1 = context.getBean(ProductServiceDynamic.class);
        ProductServiceDynamic dynamic2 = context.getBean(ProductServiceDynamic.class);

        ShoppingCart cart1 = dynamic1.createCartForUser("Tablet");
        ShoppingCart cart2 = dynamic2.createCartForUser("Audífonos");

        System.out.println("Carrito 1: " + cart1);
        System.out.println("Carrito 2: " + cart2);

        System.out.println("\n Fin del experimento de scopes.\n");
    }
    
}

