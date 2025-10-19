# Taller1_SpringACM_2025
Taller sobre IoC, scopes y dependencias en Spring Framework – ACM 2025 GRUPO1




## Punto 3 – Uso de @Qualifier en Spring Framework

Este punto demuestra cómo usar la anotación `@Qualifier` en Spring Boot para resolver ambigüedades cuando existen múltiples implementaciones de una misma interfaz.

###  Estructura del código
El ejemplo implementa un servicio de descuentos donde existen dos clases que implementan la interfaz `DiscountService`:


###  Explicación
- `@Component` registra cada clase como un bean en el contenedor de Spring.
- `@Qualifier` permite seleccionar cuál implementación inyectar.
- En este caso, `StoreController` utiliza `@Qualifier("employeeDiscountService")`.

###  Resultado
Al ejecutar la aplicación:


### Conclusión
`@Qualifier` evita conflictos cuando hay múltiples beans del mismo tipo, permitiendo indicar explícitamente cuál se debe usar.

---

**Autores:**  
ACM 2025 – Grupo 01  
Oscar Hernan Molina Munevar;
Karen Stephanny  Sanchez Vanegas;
Luis Felipe Suárez Sánchez