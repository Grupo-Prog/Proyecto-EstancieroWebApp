
## Definición de Reglas y Lógica de Negocio

### Partida
 * [ ] Establecer condiciones de finalización de la partida (reglas de bancarrota, negociación y trueques).
 * [ ] Definir mecánica de la prisión (determinar si será un estado lógico o una posición específica en el tablero).


---
### Alquileres / Propiedades
 * [ ] Determinar fórmula para el cálculo de alquileres (costo base, por chacras, por estancia, por provincia completa).
 * [ ] Programar método para compra de propiedades.
 * [ ] Implementar lógica de cobro y pago de alquileres (incluyendo cálculo según mejoras).
 * [ ] Implementar sistema de hipotecas (constituir, levantar y bloquear cobro de alquiler).
 * [ ] Desarrollar lógica de construcción de mejoras (validar posesión de provincia para chacras y conteo de chacras para estancias).
 * [ ] Programar método para venta de propiedades.
---

## Backend - Refactorización de Código

* [ ] Hacer DTOs para GameController (a algunos endpoints les vendria bien).

## Backend - Gestión de Usuarios y Autenticación
 
* [x] Implementar métodos CRUD en usuarios (create, update, findByEmail, deleteById) y validación de email único.
* [ ] Desarrollar el controlador (Controller) para la entidad User.
* [ ] Programar método de inicio de sesión (Login).
* [ ] Definir e implementar estrategia de autenticación.

## Backend - Lógica del Juego (Core)

* [ ] Implementar servicio del tablero (inicializar las 40 casillas).
* [ ] Desarrollar servicio principal del juego (métodos para crear, comenzar, buscar y terminar partida).
* [ ] Programar gestión de turnos (pasar turno y validar jugador actual).
* [ ] Implementar mecánica de lanzamiento de dados (movimiento, detección de dobles y bonificación por pasar por la salida).
* [ ] Desarrollar métodos para aplicar efectos de las tarjetas de suerte/destino.

## Backend - Inteligencia Artificial

* [ ] Implementar patrón Strategy para el comportamiento de los bots según dificultad (Fácil, Medio, Difícil).

## Frontend e Integración

* [ ] Desarrollar componentes básicos en Angular (Inicio, Login, Menú, Creación de partida).
* [ ] Integrar servicios de Angular con Backend Java para el CRUD de usuarios.
