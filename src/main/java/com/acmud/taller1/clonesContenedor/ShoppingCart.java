package com.acmud.taller1.clonesContenedor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") // cada vez que se solicite, se crea un nuevo carrito
public class ShoppingCart {
    private List<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
    }

    public List<String> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ShoppingCart@" + Integer.toHexString(System.identityHashCode(this)) +
                " - Productos: " + products;
    }
}