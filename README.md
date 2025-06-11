# SQL Escape

SQL Escape es un videojuego educativo desarrollado en **Java** cuyo objetivo es enseñar el lenguaje **SQL** a través de mecánicas de juego. Cada nivel propone un desafío que el jugador debe resolver escribiendo consultas sobre una base de datos ficticia. El proyecto surge como trabajo para la asignatura Base de Datos y Programación 2 del año lectivo 2025.

## Características principales
- Múltiples niveles con consultas de dificultad creciente.
- Validación automática de las respuestas ingresadas.
- Registro de progreso y puntuación del jugador.
- Diseño orientado a objetos y arquitectura modular.

## Requisitos de desarrollo
- **JDK 17** o superior
- **Maven** para la gestión del proyecto
- **MySQL** (puede utilizarse XAMPP u otra plataforma equivalente)

## Primeros pasos
1. Clonar este repositorio.
2. Crear la base de datos `sqlescape` ejecutando el script DDL disponible en [Annex_SQL_Code.md](Annex_SQL_Code.md).
3. Compilar el proyecto con `mvn package`.
4. Ejecutar la aplicación según el modo de interfaz implementado (gráfica o de consola).

Para obtener un listado detallado de las tareas de instalación y configuración consulte [BuildTasks.md](BuildTasks.md).

## Documentación
- [Documentation.md](Documentation.md) resume el proyecto y enlaza a los anexos.
- [Annex_SQL_Code.md](Annex_SQL_Code.md) contiene el script de base de datos.
- [Annex_UML.md](Annex_UML.md) incluye el código PlantUML de los diagramas.
- [SQL_Escape_con_ayuda.md](SQL_Escape_con_ayuda.md) conserva el documento original.

## Licencia
Este proyecto se distribuye bajo los términos de la [licencia MIT](LICENSE).
