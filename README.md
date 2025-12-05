![GESTION DE INVENTARIO PARA RESTAURANTES (Eficiencia operativa)](https://facilpos.co/wp-content/uploads/2024/09/DALL%C2%B7E-2024-09-19-22.24.20-A-vibrant-modern-restaurant-interior-with-staff-and-customers-interacting-around-a-sleek-point-of-sale-POS-system.-A-restaurant-cashier-behind-a-co-1024x585.webp)

Un software de control de inventarios en un restaurante es una de las herramientas que más impacto tiene en la eficiencia operativa, porque automatiza tareas críticas y reduce errores humanos. Su aporte puede dividirse en varias áreas clave:

Un software de control de inventarios en un restaurante mejora la eficiencia operativa al proporcionar una visibilidad clara y en tiempo real de los insumos disponibles. Esto permite evitar desabastos inesperados, compras innecesarias y pérdidas económicas. Al automatizar los registros de entradas y salidas, el negocio reduce errores humanos y acelera la gestión diaria, eliminando procesos manuales que son lentos y propensos a fallas.

Además, el sistema descuenta automáticamente los ingredientes utilizados en cada platillo vendido, lo que facilita llevar un control preciso del consumo y detectar desviaciones, robos o desperdicios. Las alertas inteligentes también ayudan a identificar productos agotados, próximos a caducar o con baja rotación, lo que contribuye a planear compras de forma más eficiente y a reducir pérdidas por merma.

El software genera reportes que permiten analizar tendencias, costos y niveles de consumo, apoyando la toma de decisiones informada en áreas como compras, producción y control financiero. Con esta información, el restaurante puede mantener la calidad del servicio, asegurar la disponibilidad de los platillos y optimizar su operación interna.

Finalmente, la trazabilidad de cada movimiento (entradas, salidas y ajustes) fortalece la transparencia y la administración del negocio, creando una base sólida para su crecimiento y la profesionalización de sus procesos.


#### Para la creación y gestión de nuestro software se cuenta con la siguiente información:


## Tabla de Contenidos

- [Resumen Ejecutivo](#resumen-ejecutivo)
- [Arquitectura del Sistema](#arquitectura-del-sistema)
- [Requerimientos Técnicos](#requerimientos-técnicos)
- [Instalación del Ambiente](#instalación-del-ambiente)
- [Implementación en Producción](#implementación-de-producción)
- [Configuración del Sistema](#configuración-del-sistema)
- [Manual del Usuario Final](#manual-de-usuario)
- [Manual del Administrador](#manual-del-administrador)
- [Contribución al Proyecto](#contribución-al-proyecto)
- [RoadMap](#roadMap)

# RESUMEN EJECUTIVO

## SISTEMA DE GESTION DE INVENTARIO PARA RESTAURANTE
Sistema integral para la gestión de restaurantes, que incluye módulos de Ventas, Inventario y Reportes, está Diseñado con una Base de Datos que cumple con los requerimientos y seguridad propuestos por el solicitante.
El principal objetivo es automatizar y optimizar los procesos operativos, garantizando un flujo eficiente desde el registro de pedidos hasta el control de inventario y la generación de reportes estratégicos.

### Descripción del proyecto

La Tradición Poblana, S.A. de C.V. requiere un sistema integral que permita registrar ventas, controlar inventario, generar reportes, administrar usuarios y asegurar la trazabilidad de todas las operaciones. El presente proyecto desarrolla un software administrativo con integración entre módulos de ventas, inventario, reportes y seguridad.

### Problema Identificado
Actualmente el restaurante registra entradas, salidas y consumos de forma manual, lo que provoca:

* Desabasto o sobreabasto de materias primas.
* Inconsistencias en la disponibilidad real de insumos.
* Pérdidas económicas por malas compras, desperdicios y mala rotación.
* Imposibilidad de planificar costos y compras.
* Retrasos en cocina y menor calidad en el servicio.

### Solución
Implementación de un sistema de control de ventas e inventario integrado, automatizando:

* Registro de pedidos.
* Descuento automático de insumos.
* Alertas de stock.
* Reportes diarios, semanales y mensuales.
* Seguridad con roles y auditoría
* Base de datos normalizada y trazabilidad completa

### Arquitectura general

* Aplicación web desarrollada en Java/Spring Boot.
* Base de datos relacional (SQL Server).
* Front-end basado en HTML/CSS/JS.
* Integración continua mediante Travis-CI.
* Gestión de versiones con branches: master, develop y branches por tarea.
* Despliegue local o en la nube (Heroku).

### Características principales

* Módulo de Ventas: Registro de pedidos, historial de ventas y actualización automática del inventario.
* Módulo de Inventario: Control de entradas y salidas de insumos, alertas de stock y caducidad, ajustes por merma y exportación a Excel/PDF.
* Módulo de Reportes: Panel visual con gráficos y tablas dinámicas, filtrado por fechas y categorías, exportación de información.
* Seguridad: Gestión de usuarios y roles, autenticación, autorización y auditoría de acciones.
* Base de Datos: Estructura escalable y segura, normalización mínima 3FN, cifrado de contraseñas.
* Interfaz de Usuario: Diseño intuitivo y adaptado para tabletas y computadoras, con colores y elementos visuales adecuados para entornos de cocina.

### Objetivos del Proyecto

* Garantizar eficiencia operativa mediante la integración de módulos.
* Asegurar trazabilidad y control de todos los procesos del restaurante.
* Facilitar la toma de decisiones a través de reportes precisos y visuales.
* Proveer una plataforma segura y confiable para la gestión diaria del restaurante.

Este sistema está diseñado para mejorar la productividad, precisión y seguridad en la operación del restaurante, integrando todas las áreas en una única solución tecnológica.


# REQUERIMIENTOS TÉCNICOS

### Hardware / Software
Servidor de aplicación: Spring Boot 3 / Tomcat 10
Servidor web opcional: Nginx
Base de datos: SQL SERVER

### Paquetes y dependencias

Java 17
Spring Boot 3.2
JPA / Hibernate
Lombok

### Spring Security

Maven
MySQL Driver
JasperReports / Apache POI

# INSTALACIÓN DEL AMBIENTE

#### 1. Clonar el repositorio
git clone https://github.com/usuario/proyecto-tradicion-poblana.git
cd proyecto-tradicion-poblana

#### 2. Configurar ambiente de desarrollo

Requisitos previos:
* Instalar Java 17
* Instalar SQLSERVER
* Crear la base de datos:

CREATE DATABASE tradicion_poblana;

#### 3. Configurar archivo application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/tradicion_poblana
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD

security.jwt.secret=CAMBIAR_SECRET

#### 4. Ejecutar el proyecto

mvn spring-boot:run

#### 5. Ejecutar pruebas manualmente

mvn test

#### 6. Implementación en producción

Local
Generar JAR:

mvn clean package
java -jar target/inventario-ventas.jar

Heroku / Railway / Render:
* Crear aplicación
* Subir JAR o conectar repositorio
* Configurar variables de entorno
* Conectar base de datos

# CONFIGURACIÓN DEL SISTEMA

### Archivos clave

* /src/main/resources/application.properties
* /config/security
* /config/inventory-config
* .env (para variables sensibles)

### Variables necesarias

* DB_HOST
* DB_USER
* DB_PASSWORD
* JWT_SECRET

# USO
  
## MANUAL DEL USUARIO FINAL


#### Módulo de Ventas

* Seleccionar platillos mediante botones grandes.
* Registrar mesa, hora y pedido.
* Enviar pedido → se descuenta automáticamente inventario.
* Consultar historial diario.

#### Módulo de Inventario

* Registrar entradas (compras).
* Ver salidas por consumo automático.
* Revisar panel semáforo:
* Verde = suficiente
* Amarillo = bajo
* Rojo = crítico
* Ajustar mermas y desperdicios.

## MANUAL DEL ADMINISTRADOR

* Crear y editar usuarios.
* Definir roles: Administrador, Cocina, Auxiliar, Ventas.
* Consultar historial completo de cambios.
* Exportar inventario a Excel/PDF.
* Configurar stock mínimo y alertas.


# CONTRIBUCIÓN AL PROYECTO

## FLUJO DE TRABAJO GITFLOW

#### Ramas principales:

* master → versión estable
* develop → integración de nuevas funcionalidades

#### Proceso para contribuir

1. Clonar repositorio:

git clone https://github.com/usuario/proyecto.git


2. Crear un branch:

git checkout -b feature/nueva-funcionalidad


3. Hacer commits:

git commit -m "Descripción del cambio"


4. Subir branch:

git push origin feature/nueva-funcionalidad


5. Crear Pull Request hacia develop

6. Esperar revisión

7. Merge → Beta

8. Versiones aprobadas pasan a GA (General Availability)


#ROADMAP

## PROXIMAS FUNCIONES

* Integración con proveedores
* Inteligencia artificial para predicción de demanda
* Dashboard con WebSockets
* Control de recetas avanzado
* Modo offline para tablets



