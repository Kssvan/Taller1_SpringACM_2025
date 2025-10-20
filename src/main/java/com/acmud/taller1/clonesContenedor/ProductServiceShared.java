package com.acmud.taller1.clonesContenedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//(Versión con el problema: todos los usuarios comparten el mismo carrito)

@Service // por defecto es singleton
public class ProductServiceShared {

    @Autowired
    private ShoppingCart cart; // este se inyecta una sola vez

    public void addItem(String product) {
        cart.addProduct(product);
    }

    public ShoppingCart getCart() {
        return cart;
    }
}