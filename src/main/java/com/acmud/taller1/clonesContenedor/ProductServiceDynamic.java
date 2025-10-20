package com.acmud.taller1.clonesContenedor;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

//(Versión corregida usando ObjectProvider para crear nuevos carritos)

@Service
public class ProductServiceDynamic {

    private final ObjectProvider<ShoppingCart> cartProvider;

    public ProductServiceDynamic(ObjectProvider<ShoppingCart> cartProvider) {
        this.cartProvider = cartProvider;
    }

    public ShoppingCart createCartForUser(String product) {
        ShoppingCart cart = cartProvider.getObject(); // obtiene una nueva instancia
        cart.addProduct(product);
        return cart;
    }
}