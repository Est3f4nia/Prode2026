<div align="center">

# Prode 2026 - Backend

**Backend del Trabajo Práctico Integrador de la materia Programación IV**

</div>

API REST para una aplicación de pronósticos deportivos (Prode).

**[Ver Frontend](https://github.com/Est3f4nia/Prode2026-Frontend)**

---

## Tecnologías utilizadas

- **Java 17** + **Spring Boot 3**
- **Spring Security** + **JWT** (autenticación stateless)
- **Spring Data JPA** + Hibernate
- **MySQL** (MySQL Workbench, base de datos local)
- **Lombok**
- **Maven**

---

## Funcionalidades principales

- Registro y login de usuarios (JWT)
- Gestión de Equipos
- Gestión de Fechas y Partidos
- Sistema de Pronósticos
- Leaderboard / Posiciones
- Validaciones y manejo centralizado de excepciones

---

## Estructura del proyecto

```
src/main/java/com/programacion4tpi/prode/
├── config/              # Configuración global de seguridad, JWT, CORS, etc.
├── exceptions/          # Manejo centralizado de errores
├── feature/
│   ├── usuario/         # Autenticación y usuarios
│   ├── equipo/          # Gestión de equipos
│   ├── fecha/           # Gestión de fechas
│   ├── partido/         # Gestión de partidos
│   └── pronostico/      # Gestión de pronósticos de los usuarios
└── ProdeApplication.java
```

---

## Ejecución

### Requisitos

- Java 17+
- MySQL 8
- Maven

### Base de datos

Ejecutar `docs/prodetpi.sql` desde un motor MySQL.

### Configuración
Configura las variables de entorno necesarias (ver `application.properties`).

### Ejecutar

La API estará disponible en: `http://localhost:8080`

---

## Endpoints principales (ejemplos)

| Método | Endpoint                  | Descripción                  |
|--------|---------------------------|------------------------------|
| POST   | `/api/auth/register`      | Registro de usuario          |
| POST   | `/api/auth/login`         | Login (devuelve JWT)         |
| GET    | `/api/equipos`            | Listar equipos               |
| GET    | `/api/partidos`           | Listar partidos              |
| POST   | `/api/pronosticos`        | Crear/actualizar pronóstico  |
| GET    | `/api/posiciones`         | Tabla de posiciones          |

> Para ver todos los endpoints detallados, revisar los controllers dentro de `feature/`.

---

## Notas importantes

- **Autenticación**: Se implementó **JWT stateless** almacenado en `localStorage` en el frontend (solución rápida para el TPI).
- Seguridad: CORS configurado para aceptar peticiones del frontend.
- Manejo de errores centralizado con `@ControllerAdvice`.

---

## Documentación adicional

- [Diagrama de Clases](./docs/DiagramaDeClases.pdf)
- [Script SQL](./docs/prodetpi.sql)

---

**Proyecto realizado en equipo**