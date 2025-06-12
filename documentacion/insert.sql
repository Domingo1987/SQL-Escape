SET FOREIGN_KEY_CHECKS=0;

-- Inserts for MARINERO
INSERT INTO MARINERO (id, nombre, edad, descripcion, pais_origen) VALUES
    (1, 'Juan Perez', 34, 'Capitan experimentado', 'Chile'),
    (2, 'Maria Gomez', 28, 'Especialista en navegacion', 'Uruguay'),
    (3, 'Luis Rodriguez', 45, 'Experto en motores', 'Argentina');

-- Inserts for BARCO
INSERT INTO BARCO (nro_barco, camarotes, max_combustible, pais_origen, material, velocidad_crucero) VALUES
    (1, 50, 500.00, 'Panama', 'acero', 25.5),
    (2, 75, 750.00, 'España', 'fibra de vidrio', 30.0);

-- Inserts for ISLA
INSERT INTO ISLA (nombre, flora, habitantes, fauna, puerto, estructura) VALUES
    ('Isla del Sol', 'Vegetacion tropical', 100, 'Aves exoticas', TRUE, 'Formacion rocosa'),
    ('Isla Esmeralda', 'Bosques densos', 50, 'Monos y reptiles', TRUE, 'Playa y montanas');

-- Inserts for SENSOR
INSERT INTO SENSOR (nro_barco, tipo, ubicacion, anios_servicio) VALUES
    (1, 'temperatura', 'cubierta', 5),
    (1, 'presion', 'sala de maquinas', 3),
    (2, 'humedad', 'bodega', 2);

-- Inserts for REGISTRO_COMBUSTIBLE
INSERT INTO REGISTRO_COMBUSTIBLE (nro_barco, fecha, cantidad_utilizada) VALUES
    (1, '2024-01-15', 300.00),
    (2, '2024-01-15', 400.00),
    (1, '2024-02-15', 350.00);

-- Inserts for TRIPULANTE
INSERT INTO TRIPULANTE (id, nro_barco, fecha_ingreso, fecha_cese, rango) VALUES
    (1, 1, '2024-01-01', NULL, 'Capitan'),
    (2, 1, '2024-01-01', NULL, 'Timonel'),
    (3, 2, '2024-01-01', NULL, 'Mecanico');

-- Inserts for NAVEGACION
INSERT INTO NAVEGACION (nro_barco, nombre, fecha, estado) VALUES
    (1, 'Isla del Sol', '2024-01-10', 'saliente'),
    (1, 'Isla Esmeralda', '2024-01-20', 'entrante'),
    (2, 'Isla Esmeralda', '2024-01-15', 'saliente');

SET FOREIGN_KEY_CHECKS=1;
