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

INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(2,
 'El Libro de Guardia',
 'El barco cruje mientras la niebla envuelve la cubierta. Caminás con cautela hasta una mesa de madera donde descansa un grueso libro: 
  el Libro de Guardia. En su interior se registran los nombres de quienes están a bordo.\nUna nota escrita a mano te desafía:\n
 “El conocimiento empieza por reconocer a quienes navegan contigo.”',
 'Mostrá una lista con los nombres de toda la tripulación registrada hasta ahora.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(2, 'SELECT nombre FROM MARINERO;'),
(2, 'SELECT * FROM MARINERO;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE','DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(3,
 'Las Bitácoras del Silencio',
 'En la sala de mando hay pantallas parpadeando. Una de ellas muestra las últimas rutas navegadas. El capitán dejó un mensaje cifrado:\n“Toda travesía deja rastro en el tiempo y el estado de sus mares.”\n\nPista técnica:\nRevisá la tabla NAVEGACION. Las columnas que necesitás son FECHA y ESTADO.',
 'Obtené la fecha y el estado de todas las navegaciones registradas.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(3, 'SELECT fecha, estado FROM NAVEGACION;'),
(3, 'SELECT DISTINCT fecha, estado FROM NAVEGACION;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');

INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(4,
 'Ecos en los Sensores',
 'En la sala de máquinas, luces tenues revelan una hilera de sensores antiguos. Un archivo olvidado titulado "Prioridad de Mantenimiento" contiene una advertencia:\n“Quien vigile más tiempo, necesita más atención.”\n\nPista técnica:\nConsultá la tabla SENSOR. Las columnas útiles son tipo y anios_servicio.',
 'Mostrá todos los sensores ordenados por sus años de servicio, del mayor al menor.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(4, 'SELECT tipo, anios_servicio FROM SENSOR ORDER BY anios_servicio DESC;'),
(4, 'SELECT S.tipo, S.anios_servicio FROM SENSOR S ORDER BY S.anios_servicio DESC;'),
(4, 'SELECT tipo, anios_servicio FROM SENSOR WHERE anios_servicio > 0 ORDER BY anios_servicio DESC;'),
(4, 'SELECT tipo, anios_servicio FROM SENSOR ORDER BY anios_servicio DESC LIMIT 3;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(5,
 'El Diario del Combustible',
 'Un compartimiento revela tanques oxidados y hojas con números. Una frase está tallada en la compuerta:\n“Los barcos que más recorren, más dejan huella en su consumo.”\n\nPista técnica:\nRevisá la tabla REGISTRO_COMBUSTIBLE. Las columnas necesarias son FECHA y cantidad_utilizada.',
 'Mostrá la cantidad de combustible utilizado en cada fecha registrada.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(5, 'SELECT fecha, cantidad_utilizada FROM REGISTRO_COMBUSTIBLE;'),
(5, 'SELECT R.fecha, R.cantidad_utilizada FROM REGISTRO_COMBUSTIBLE R;'),
(5, 'SELECT fecha, cantidad_utilizada FROM REGISTRO_COMBUSTIBLE ORDER BY cantidad_utilizada DESC;'),
(5, 'SELECT fecha, cantidad_utilizada FROM REGISTRO_COMBUSTIBLE WHERE cantidad_utilizada > 100;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');

INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(6,
 'El Código del Capitan',
 'La sala de planos está en penumbras. Sobre una mesa metálica, hay planos técnicos firmados por diferentes marineros. Un mensaje en la pared dice:\n"Quien diseña, deja su firma."',
 'Desafío:\nMostrá los nombres de los marineros cuya descripción contenga la palabra "Capitan".'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(6, 'SELECT nombre FROM MARINERO WHERE descripcion LIKE ''%Capitan%'';'),
(6, 'SELECT M.nombre FROM MARINERO M WHERE M.descripcion LIKE ''%Capitan%'';'),
(6, 'SELECT nombre FROM MARINERO WHERE LOWER(descripcion) LIKE ''%Capitan%'';'),
(6, 'SELECT nombre FROM MARINERO WHERE descripcion LIKE ''%Ingeniero%'' ORDER BY nombre ASC;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(7,
 'El Archivo Genético del Barco',
 'En la enfermería, un escáner muestra datos de salud. Un archivo titulado Estado Físico de la Tripulación aparece en pantalla:\n"El cuerpo también navega."',
 'Desafío: Mostrá el nombre y la edad de los marineros mayores de 40 años.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(7, 'SELECT nombre, edad FROM MARINERO WHERE edad > 40;'),
(7, 'SELECT M.nombre, M.edad FROM MARINERO M WHERE M.edad > 40;'),
(7, 'SELECT nombre, edad FROM MARINERO WHERE edad >= 41;'),
(7, 'SELECT nombre, edad FROM MARINERO WHERE edad > 40 ORDER BY edad DESC;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(8,
 'Coordenadas de la Verdad',
 'Un mapa digital titila con los últimos puntos geográficos visitados. Una nota automática dice:\n"Las islas revelan su esencia en cada detalle."',
 'Desafío: Mostrá el nombre y la cantidad de habitantes de todas las islas registradas.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(8, 'SELECT nombre, habitantes FROM ISLA;'),
(8, 'SELECT I.nombre, I.habitantes FROM ISLA I;'),
(8, 'SELECT nombre, habitantes FROM ISLA WHERE puerto = TRUE;'),
(8, 'SELECT nombre, habitantes FROM ISLA ORDER BY habitantes DESC;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(9,
 'Tiempo en el Mar',
 'Una vieja bitácora muestra los movimientos de cada barco entre las islas, marcando cuándo entraron y salieron de puerto. Una frase destaca:\n"No importa solo a dónde, sino cuánto duró cada travesía."',
 'Desafío: Mostrá el número de barco (nro_barco) y la fecha (fecha) de todas las entradas y salidas registradas, junto con el estado (si es entrante o saliente).'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(9, 'SELECT nro_barco, fecha, estado FROM NAVEGACION;'),
(9, 'SELECT N.nro_barco, N.fecha, N.estado FROM NAVEGACION N;'),
(9, 'SELECT nro_barco, fecha, estado FROM NAVEGACION WHERE estado = ''saliente'';'),
(9, 'SELECT nro_barco, fecha, estado FROM NAVEGACION ORDER BY nro_barco ASC, fecha ASC;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');


INSERT INTO NIVEL (numero, titulo, narrativa, pregunta) VALUES
(10,
 'Tiempo en el Mar',
 'Frente al núcleo de control, un monitor muestra alertas sobre sensores. En letras rojas aparece:\n"El tipo de sensor predice la falla."',
 'Desafío: Mostrá cuántos sensores hay de cada tipo, es decir, contá cuántos sensores corresponden a cada tipo registrado.'
);

INSERT INTO CONSULTA (nivel_id, consulta) VALUES
(10, 'SELECT tipo, COUNT(*) AS cantidad FROM SENSOR GROUP BY tipo;'),
(10, 'SELECT S.tipo, COUNT(*) AS cantidad FROM SENSOR S GROUP BY S.tipo;'),
(10, 'SELECT tipo, COUNT(*) AS cantidad FROM SENSOR GROUP BY tipo ORDER BY cantidad DESC;'),
(10, 'SELECT tipo AS TipoSensor, COUNT(*) AS TotalSensores FROM SENSOR GROUP BY tipo;');

INSERT INTO CONSULTA_PREDEFINIDA (nombre, consulta) VALUES
('LISTAR_TABLAS', 'SHOW TABLES;'),
('DESCRIBIR_MARINERO', 'DESCRIBE MARINERO;'),
('DESCRIBIR_BARCO', 'DESCRIBE BARCO;'),
('DESCRIBIR_ISLA', 'DESCRIBE ISLA;'),
('DESCRIBIR_SENSOR', 'DESCRIBE SENSOR;'),
('DESCRIBIR_REGISTRO_COMBUSTIBLE', 'DESCRIBE REGISTRO_COMBUSTIBLE;'),
('DESCRIBIR_TRIPULANTE', 'DESCRIBE TRIPULANTE;'),
('DESCRIBIR_NAVEGACION', 'DESCRIBE NAVEGACION;');
