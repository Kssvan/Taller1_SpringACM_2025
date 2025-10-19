package com.acmud.taller1.qualifiers;

import org.springframework.stereotype.Component;

@Component("studentDiscountService")
public class StudentDiscountService implements DiscountService {
    @Override
    public double getDiscount() {
        return 0.20; // 20% de descuento para estudiantes
    }
}
