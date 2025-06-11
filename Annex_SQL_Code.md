# Anexo: Código SQL de SQL Escape

Este anexo recopila el script de creación de la base de datos y las operaciones de manipulación utilizadas por el juego. Los fragmentos provienen del documento original `SQL_Escape_con_ayuda.md`.

## Script DDL

```sql
CREATE DATABASE IF NOT EXISTS sqlescape;

USE sqlescape;

CREATE TABLE MARINERO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    edad INT,
    descripcion TEXT,
    pais_origen VARCHAR(50)
);

CREATE TABLE BARCO (
    nro_barco INT PRIMARY KEY AUTO_INCREMENT,
    camarotes INT,
    max_combustible DECIMAL(10,2),
    pais_origen VARCHAR(50),
    material VARCHAR(50),
    velocidad_crucero DECIMAL(5,2)
);

CREATE TABLE ISLA (
    nombre VARCHAR(50) PRIMARY KEY,
    flora TEXT,
    habitantes INT,
    fauna TEXT,
    puerto BOOLEAN,
    estructura TEXT
);

CREATE TABLE SENSOR (
    nro_barco INT,
    tipo VARCHAR(30),
    ubicacion VARCHAR(50),
    anios_servicio INT,
    PRIMARY KEY (nro_barco, tipo),
    FOREIGN KEY (nro_barco) REFERENCES BARCO(nro_barco)
);

CREATE TABLE REGISTRO_COMBUSTIBLE (
    nro_barco INT,
    fecha DATE,
    cantidad_utilizada DECIMAL(10,2),
    PRIMARY KEY (nro_barco, fecha),
    FOREIGN KEY (nro_barco) REFERENCES BARCO(nro_barco)
);

CREATE TABLE TRIPULANTE (
    id INT,
    nro_barco INT,
    fecha_ingreso DATE,
    fecha_cese DATE,
    rango VARCHAR(30),
    PRIMARY KEY (id, nro_barco),
    FOREIGN KEY (id) REFERENCES MARINERO(id),
    FOREIGN KEY (nro_barco) REFERENCES BARCO(nro_barco)
);

CREATE TABLE NAVEGACION (
    nro_barco INT,
    nombre VARCHAR(50),
    fecha DATE,
    estado ENUM('entrante', 'saliente'),
    PRIMARY KEY (nro_barco, nombre, fecha),
    FOREIGN KEY (nro_barco) REFERENCES BARCO(nro_barco),
    FOREIGN KEY (nombre) REFERENCES ISLA(nombre)
);
```

## Operaciones DML

- **SELECT**: recuperar información específica de las tablas.
- **INSERT**: agregar nuevos registros, como jugadores o resultados.
- **UPDATE**: modificar datos existentes, por ejemplo el progreso del jugador.
- **DELETE**: eliminar registros obsoletos.

## DCL y TCL

No se emplean sentencias DCL ni TCL en el proyecto. El control de accesos y las transacciones se manejan desde la lógica de Java.

