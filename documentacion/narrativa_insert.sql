INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
    (1,
     'Bienvenida',
     'Despiertas en la sala de control de un barco abandonado.
      Todo está oscuro y polvoriento. Las luces parpadean mientras un panel digital te muestra un mensaje: 
      “Consulta los registros del personal para abrir la compuerta principal”. Debes resolver una consulta SQL para continuar...',
     '¿Cuántos marineros hay registrados?');

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
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
