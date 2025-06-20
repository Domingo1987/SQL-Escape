# SQL Escape

SQL Escape es un videojuego educativo desarrollado en **Java** cuyo objetivo es enseñar el lenguaje **SQL** a través de mecánicas de juego. Cada nivel propone un desafío que el jugador debe resolver escribiendo consultas sobre una base de datos ficticia. El proyecto surge como trabajo para la asignatura Base de Datos y Programación 2 del año lectivo 2025.

## Características principales
- Múltiples niveles con consultas de dificultad creciente.
- Validación automática de las respuestas ingresadas.
- Registro de progreso y puntuación del jugador.
- Diseño orientado a objetos y arquitectura modular.
- Uso de patrones de diseño **DAO**, **Facade** y **MVC** para una estructura
  clara y extensible.

## Requisitos de desarrollo
- **JDK 17** o superior
- **Maven** para la gestión del proyecto
- **MySQL** (puede utilizarse XAMPP u otra plataforma equivalente)

## Primeros pasos
1. Clonar este repositorio.
2. Crear la base de datos `sqlescape` ejecutando el script DDL de [data.sql](documentacion/data.sql). El mismo contenido se encuentra descrito en [Annex_SQL_Code.md](documentacion/Annex_SQL_Code.md).
3. Crear la base `narrativa` con el script [narrativa.sql](documentacion/narrativa.sql). Luego ejecutar [narrativa_insert.sql](documentacion/narrativa_insert.sql) para cargar un nivel de prueba y las consultas predefinidas.
4. Generar el ejecutable con `mvn package`.
5. Ejecutar la interfaz gráfica utilizando el JAR producido en la carpeta `target`.


Para obtener un listado detallado de las tareas de instalación y configuración consulte [BuildTasks.md](documentacion/BuildTasks.md).

## Documentación
- [Documentation.md](documentacion/Documentation.md) resume el proyecto y enlaza a los anexos.
- [Annex_SQL_Code.md](documentacion/Annex_SQL_Code.md) contiene el script de base de datos.
- [data.sql](documentacion/data.sql) es el script utilizable para crear la base `sqlescape`.
- [narrativa.sql](documentacion/narrativa.sql) define la base `narrativa` para la narrativa y preguntas.
- [narrativa_insert.sql](documentacion/narrativa_insert.sql) añade un nivel de ejemplo, sus soluciones y las consultas predefinidas.
- [Annex_UML.md](documentacion/Annex_UML.md) incluye el código PlantUML de los diagramas.
- [SQL_Escape_con_ayuda.md](documentacion/SQL_Escape_con_ayuda.md) conserva el documento original.

## Licencia
Este proyecto se distribuye bajo los términos de la [licencia MIT](documentacion/LICENSE).
