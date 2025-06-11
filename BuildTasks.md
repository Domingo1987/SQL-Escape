# Tareas para Construir SQL Escape desde Cero

Este archivo describe los pasos principales para poner en marcha el proyecto SQL Escape partiendo de un entorno limpio.

1. **Preparar el entorno de desarrollo**
   - Instalar JDK 17 o superior.
   - Instalar Maven para la gestión del proyecto.
   - Instalar MySQL (o un motor compatible) y una herramienta como XAMPP para la administración local.

2. **Configurar la base de datos**
   - Crear la base `sqlescape` ejecutando los scripts DDL incluidos en la documentación.
   - Verificar que las tablas `MARINERO`, `BARCO`, `ISLA`, `SENSOR`, `REGISTRO_COMBUSTIBLE`, `TRIPULANTE` y `NAVEGACION` estén correctamente creadas.

3. **Estructurar el proyecto Java**
   - Inicializar un proyecto Maven (`mvn archetype:generate`) si no existe uno.
   - Incorporar las clases descritas en el diagrama de clases: `SqlEscapeGame`, `Player`, `Level`, `Challenge`, `SqlEvaluator`, `SqlSyntaxValidator`, `GameDatabase` y los DAO correspondientes.
   - Aplicar los patrones especificados (Singleton para la base de datos, DAO, State, etc.).

4. **Implementar la lógica del juego**
   - Programar los casos de uso principales (iniciar partida, resolver desafío, validar consulta, avanzar de nivel, guardar progreso).
   - Integrar la narrativa y los desafíos por nivel.
   - Registrar intentos y puntajes en la base de datos.

5. **Construir la interfaz de usuario**
   - Puede ser textual o gráfica, según la decisión del equipo.
   - Permitir ingresar consultas SQL y mostrar los resultados o mensajes de error de forma clara.

6. **Pruebas y validaciones**
   - Crear pruebas unitarias para las clases principales.
   - Verificar que las consultas SQL se evalúan correctamente y que el progreso se almacena.

7. **Ejecución y ajustes finales**
   - Compilar el proyecto con `mvn package`.
   - Ejecutar la aplicación, comprobar que los niveles se cargan y que la experiencia completa funciona sin errores.
   - Documentar cualquier configuración adicional necesaria.

Con estas tareas completadas, el proyecto estará listo para su distribución o para añadir nuevas funcionalidades.
