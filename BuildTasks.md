# Tareas para Construir SQL Escape desde Cero

Este archivo detalla de forma secuencial cómo levantar el proyecto y conectarlo con MySQL/XAMPP a partir de un entorno limpio. Cada punto puede ejecutarse inmediatamente después del anterior.

1. **Preparar el entorno**
   - Instalar **JDK 17** o superior y verificarlo con `java -version`.
   - Instalar **Maven** para la gestión del proyecto (`mvn -version`).
   - Instalar **XAMPP** (o MySQL equivalente).
   - Iniciar el servicio **MySQL** desde el panel de control de XAMPP y comprobar que responde en `localhost:3306`.

2. **Clonar el repositorio**
   - Obtener los archivos de este proyecto ejecutando `git clone` sobre el repositorio.

3. **Crear las bases de datos**
   - Desde la consola de MySQL o phpMyAdmin:
     - Ejecutar `data.sql` (o el código de `Annex_SQL_Code.md`) para generar la base **sqlescape**.
     - Ejecutar `narrativa.sql` y `narrativa_insert.sql` para la base **narrativa**.
   - Verificar que las tablas `MARINERO`, `BARCO`, `ISLA`, `SENSOR`, `REGISTRO_COMBUSTIBLE`, `TRIPULANTE`, `NAVEGACION`, `NIVEL`, `SOLUCION` y `CONSULTA_PREDEFINIDA` existen.

4. **(Opcional) Cargar datos de ejemplo**
   - Ejecutar `insert.sql` si se desean registros de muestra en **sqlescape**.

5. **Iniciar un proyecto Maven**
   - Ejecutar el siguiente comando para generar la estructura basica:
     `mvn archetype:generate -DgroupId=com.example -DartifactId=sql-escape -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
     Verificar que el codigo fuente quede en `src/main/java`.
   - Anadir al `pom.xml` la dependencia del conector MySQL y JUnit para las pruebas:

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.3.0</version>
</dependency>
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.13.2</version>
  <scope>test</scope>
</dependency>
```
   - Crear `src/main/resources/db.properties` con la URL `jdbc:mysql://localhost/sqlescape` y las credenciales de MySQL.

6. **Diseñar la estructura Java**
   - Crear las clases descritas en `Annex_UML.md`: `SqlEscapeGame`, `Player`, `Level`, `Challenge`, `SqlEvaluator`, `SqlSyntaxValidator`, `GameDatabase` y sus DAO.
   - Aplicar los patrones **Singleton** (conexión), **DAO**, **State**, **Facade** y **MVC**.

7. **Implementar la lógica del juego**
   - Programar los casos de uso: iniciar partida, resolver consultas, validar, avanzar de nivel y guardar progreso.
   - Integrar la narrativa y registrar los intentos y la puntuación en la base de datos.

8. **Construir la interfaz de usuario**
   - Implementar una interfaz gráfica con JavaFX o Swing para introducir consultas y mostrar los resultados.

9. **Crear pruebas y validaciones**
   - Escribir pruebas unitarias para las clases principales y validar que el progreso se persiste correctamente.

10. **Compilar y ejecutar**
    - Ejecutar `mvn clean package` para compilar y generar el JAR.
    - Iniciar la aplicación con `java -jar target/NombreDelJar.jar`.
    - Probar que los niveles se cargan sin errores y que se conecta a la base de datos.

11. **Documentar ajustes finales**
    - Registrar cualquier configuración adicional realizada durante la instalación o ejecución.

Con estas tareas el proyecto puede recrearse desde cero y quedar listo para ampliar funcionalidades.
