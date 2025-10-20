# Taller1_SpringACM_2025
Taller sobre IoC, scopes y dependencias en Spring Framework – ACM 2025 GRUPO1

## Punto 2 – Scopes y gestión de instancias en Spring Framework

Este punto demuestra cómo los **alcances (scopes)** de los beans afectan la creación y uso de instancias dentro del contenedor de Spring.  
El ejercicio simula un **sistema de carrito de compras**, donde inicialmente todos los usuarios comparten el mismo carrito, y luego se corrige este comportamiento usando `ObjectProvider`.

---

###  Estructura del código

El ejemplo implementa tres clases principales:

- `ShoppingCart`: Bean con `@Scope("prototype")`, representa el carrito de cada usuario.  
- `ProductServiceShared`: Servicio `@Singleton` que inyecta el carrito directamente (provocando que todos compartan el mismo).  
- `ProductServiceDynamic`: Servicio que utiliza `ObjectProvider` para solicitar una **nueva instancia** de `ShoppingCart` cada vez.  

---

###  Explicación

- En el **primer escenario**, `ProductServiceShared` inyecta el carrito con `@Autowired`.  
  Aunque `ShoppingCart` es *prototype*, Spring lo inyecta una sola vez dentro del servicio *singleton*, por lo que todos los usuarios comparten el mismo carrito.  
- En el **segundo escenario**, `ProductServiceDynamic` usa `ObjectProvider<ShoppingCart>` para obtener un carrito nuevo en cada llamada, logrando así independencia entre usuarios.  

El método `run()` en la clase principal imprime ambos casos para comparar los resultados.

---

###  Resultado

**Escenario 1 — Inyección directa (error):**  
Todos los usuarios comparten el mismo carrito.  
**Escenario 2 — Uso de ObjectProvider (solución):**  
Cada usuario tiene su propio carrito.  

---

### 🧾 Conclusión

El alcance (*scope*) de un bean determina su ciclo de vida y número de instancias en la aplicación.  
Los beans *singleton* se crean una sola vez por contexto, mientras que los *prototype* generan una nueva instancia cada vez que se solicitan.  

Sin embargo, cuando un *singleton* inyecta un *prototype*, este se convierte en una sola referencia.  
Para mantener la naturaleza dinámica del *prototype*, se debe usar `ObjectProvider`, `ApplicationContext.getBean()` o `@Lookup`, garantizando que cada solicitud reciba su propia instancia.  

---

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