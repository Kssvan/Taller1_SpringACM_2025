package com.acmud.taller1.qualifiers;

import org.springframework.stereotype.Component;

@Component("employeeDiscountService")
public class EmployeeDiscountService implements DiscountService {
    @Override
    public double getDiscount() {
        return 0.35; // 35% de descuento para empleados
    }
}
