# Documentación de SQL Escape


## 1. Resumen Ejecutivo
SQL Escape es un videojuego educativo escrito en **Java** cuyo propósito principal es facilitar el aprendizaje de **SQL**. A lo largo de más de diez niveles el jugador debe resolver desafíos utilizando consultas sobre una base de datos ficticia. Cada nivel está integrado en una narrativa que motiva la exploración y fomenta la resolución de problemas.

## 2. Alcance y Objetivos
- Enseñar SQL mediante una plataforma interactiva.
- Fomentar el pensamiento lógico para superar los desafíos.
- Mantener al jugador motivado con una historia y elementos de juego.
- Evaluar automáticamente las respuestas y registrar el progreso.

La aplicación está dirigida a estudiantes, autodidactas y docentes que deseen una herramienta pedagógica diferente.

## 3. Arquitectura General
El proyecto adopta una arquitectura orientada a objetos y utiliza:
- **Java** como lenguaje principal.
- **MySQL** administrado localmente con XAMPP u otra herramienta similar.
- **Maven** para la construcción y gestión de dependencias.

## 4. Análisis de Requisitos y Casos de Uso
### 4.1 Actores del Sistema
- **Jugador/Estudiante:** interactúa con el juego y resuelve los desafíos.
- **Docente:** puede consultar el progreso del estudiante.
- **Sistema de Evaluación:** componente automatizado que valida las consultas.

### 4.2 Diagrama de Casos de Uso
El código PlantUML del diagrama se encuentra en [Annex_UML.md](Annex_UML.md). Describe la relación entre los actores y los casos principales: iniciar partida, resolver desafíos SQL, validar consultas, avanzar de nivel y guardar el progreso.

### 4.3 Especificación de Casos de Uso
Se detallan las interacciones básicas:
- **UC01: Iniciar Partida** – el jugador crea o continúa su juego.
- **UC02: Resolver Desafío SQL** – introduce la consulta, se valida y muestra el resultado.
- **UC03: Validar Consulta SQL** – verifica sintaxis y tablas permitidas.
- **UC04: Avanzar de Nivel** – actualiza el progreso y carga el siguiente reto.
- **UC05: Guardar Progreso** – persiste la información de avance del jugador.

## 5. Diseño Orientado a Objetos
### 5.1 Diagrama de Clases
El diagrama completo está disponible en [Annex_UML.md](Annex_UML.md). Incluye clases como `SqlEscapeGame`, `Player`, `Level`, `Challenge`, `SqlEvaluator` y las DAO utilizadas para la persistencia.

### 5.2 Descripción de Clases Principales
- **SqlEscapeGame:** controla el flujo del juego.
- **Player / PlayerProgress:** almacenan datos y avances del jugador.
- **Level / Challenge:** definen cada nivel y su consulta esperada.
- **SqlEvaluator / SqlSyntaxValidator:** ejecutan y verifican las consultas.
- **GameDatabase y DAO:** gestionan la conexión y las operaciones sobre la base de datos.

### 5.3 Patrones de Diseño
Se aplican patrones como **Singleton** (para la base de datos), **DAO** y **State** para la gestión del estado del juego.

## 6. Análisis de Base de Datos
### 6.1 Modelos MER y MR
El documento original describe dos modelos entidad–relación: uno para el universo de juego y otro para la gestión de usuarios y niveles. Dichos modelos se transforman en un modelo relacional normalizado hasta **3FN**.

### 6.2 Scripts SQL
El script de creación de tablas y las operaciones DML básicas se incluyen en [Annex_SQL_Code.md](Annex_SQL_Code.md). No se utilizan sentencias DCL ni TCL porque el control se realiza desde Java.

## 7. Análisis de Programación
Se analizan los elementos funcionales del sistema y se describen los casos de uso, los escenarios narrativos y un glosario de términos que sirven de base para la siguiente fase de diseño.

## 8. Implementación
El juego se implementa en Java con conexión a una base de datos MySQL. Para montar el proyecto desde cero se puede seguir la guía de [BuildTasks.md](BuildTasks.md).

## 9. Apéndices
- [Annex_SQL_Code.md](Annex_SQL_Code.md) – script de base de datos y operaciones SQL.
- [Annex_UML.md](Annex_UML.md) – código PlantUML para generar los diagramas.

Con esta organización el contenido de `SQL_Escape_con_ayuda.md` queda estructurado de forma más clara y con acceso directo a los anexos relevantes.
