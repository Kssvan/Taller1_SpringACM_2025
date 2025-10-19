package com.acmud.taller1.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StoreController {

    private final DiscountService discountService;

    @Autowired
    public StoreController(@Qualifier("employeeDiscountService") DiscountService discountService) {
        this.discountService = discountService;
    }

    public void showDiscount() {
        System.out.println("El descuento aplicado es: " + (discountService.getDiscount() * 100) + "%");
    }
}
