INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
    (1,
     'Bienvenida',
     'Despiertas en la sala de control de un barco abandonado. Debes resolver una consulta SQL para abrir la puerta.',
     '¿Cuántos marineros hay registrados?');

INSERT INTO SOLUCION (nivel_id, consulta) VALUES
    (1, 'SELECT COUNT(*) FROM MARINERO;'),
    (1, 'SELECT COUNT(id) FROM MARINERO;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
    ('LISTAR_TABLAS', 'SHOW TABLES;'),
    ('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
    ('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
    ('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
    ('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
    ('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
    ('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
    ('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');
