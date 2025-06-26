package com.cerp;

import com.cerp.SqlEscapeGame;
import com.cerp.db.GameDatabase;
import com.cerp.db.PlayerDAO;
import com.cerp.db.ProgressDAO;
import com.cerp.db.LevelDAO;
import com.cerp.db.ConsultasDAO;
import com.cerp.facade.GameFacade;
import com.cerp.mvc.GameController;
import com.cerp.mvc.GameView;
import com.cerp.mvc.SwingGameView;
import com.cerp.mvc.TestGameView;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Entry point for SQL Escape. Loads the configuration and starts the game.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        Logger.log("App.main");

        Properties props = new Properties();
        try (InputStream in = App.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in != null) {
                props.load(in);
            } else {
                System.out.println("No se encontró el archivo de configuración de la base de datos.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error al leer la configuración: " + e.getMessage());
            return;
        }

        String url_narrativa = props.getProperty("url_narrativa");
        String url_sqlescape = props.getProperty("url_sqlescape");
        String user = props.getProperty("user");
        String pass = props.getProperty("password");

        // Conectar a base de datos narrativa
        //GameDatabase db_narrativa = GameDatabase.getInstance(url_narrativa, user, pass);
        GameDatabase db_narrativa = new GameDatabase(url_narrativa, user, pass);
        if (!db_narrativa.connect()) {
            System.out.println("No se pudo conectar a la base de datos narrativa.");
            return;
        }

        // Conectar a base de datos sqlescape
        // GameDatabase db_sqlescape = GameDatabase.getInstance(url_sqlescape, user, pass);
        GameDatabase db_sqlescape = new GameDatabase(url_sqlescape, user, pass);
        if (!db_sqlescape.connect()) {
            System.out.println("No se pudo conectar a la base de datos sqlescape.");
            return;
        }

        // Inicializar componentes del juego
        SqlEscapeGame game = new SqlEscapeGame(db_sqlescape);
        PlayerDAO playerDAO = new PlayerDAO(db_narrativa);
        ProgressDAO progressDAO = new ProgressDAO(db_narrativa);
        LevelDAO levelDAO = new LevelDAO(db_narrativa);
        ConsultasDAO consultasDAO = new ConsultasDAO(db_narrativa);

        // Crear facade con todos los DAOs
        GameFacade facade = new GameFacade(game, playerDAO, progressDAO, levelDAO, consultasDAO);

        // Crear vista (cambiar entre TestGameView y SwingGameView según necesites)
        GameView view = new TestGameView();
        //GameView view = new SwingGameView();

        GameController controller = new GameController(facade, view);

        // Iniciar el juego
        facade.startGame();
        controller.showLevel();

        // Procesar consulta del usuario
        String query = view.getUserQuery();
        Logger.logRed("Consulta del usuario: " + query);
        controller.handleQuery(query);

        // Cerrar conexiones
        game.exitGame();
    }
}