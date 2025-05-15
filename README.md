# 📦 API de Franquicias

Este proyecto es una API REST desarrollada en **Spring Boot** que permite gestionar **franquicias**, **sucursales** y **productos**, con persistencia en **SQL Server**.

## ✅ Requisitos

- Java 17 o superior
- Maven
- SQL Server
- Postman (opcional para pruebas)
- Docker (opcional, para contenerización)

---
## ✅ Construir la imagen

docker build -t mi-springboot-app .

## Ejecutar la imagen

docker run --rm -p 8080:8080 mi-springboot-app

## ⚙️ Instalación local

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/Gperez007/BackenFanquiciaApi.git
   cd tu-repo

   ## Instrucciones para crear la base de datos y las tablas

1. **Conéctate a tu servidor SQL Server** usando una herramienta como **SQL Server Management Studio (SSMS)** o **Azure Data Studio**.

2. **Crea la base de datos**:
   Ejecute el siguiente script SQL para crear la base de datos `franquicia_db`:

   ```sql
   CREATE DATABASE franquicia_db;
   GO

*--* Crear la base de datos
  ```sql
CREATE DATABASE franquicia_db;
GO

USE franquicia_db;
GO

-- Tabla de Franquicias
CREATE TABLE franquicias (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL
);
GO

-- Tabla de Sucursales
CREATE TABLE sucursales (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL,
    franquicia_id INT NOT NULL,
    FOREIGN KEY (franquicia_id) REFERENCES franquicias(id)
);
GO

-- Tabla de Productos
CREATE TABLE productos (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    sucursal_id INT NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id)
);
GO



## ⚙️ Configurar la conexión a la base de datos

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=franquicia_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=none

4. Ejecutar la aplicación

./mvnw spring-boot:run

📌 Endpoints principales
Método	Endpoint	Descripción
POST	/franquicias	Crear una nueva franquicia
POST	/franquicias/{id}/sucursales	Agregar una sucursal a una franquicia
POST	/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos	Agregar producto a sucursal
DELETE	/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}	Eliminar un producto
PUT	/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/stock	Modificar stock de un producto
GET	/franquicias/{franquiciaId}/productos-con-mas-stock	Obtener productos con más stock por sucursal
PUT	/franquicias/{id}	Actualizar nombre de una franquicia
PUT	/sucursales/{id}	Actualizar nombre de una sucursal
PUT	/productos/{id}	Actualizar nombre de un producto