package com.cerp;

import com.cerp.SqlEscapeGame;
import com.cerp.db.GameDatabase;
import com.cerp.db.PlayerDAO;
import com.cerp.db.ProgressDAO;
import com.cerp.db.LevelDAO;
import com.cerp.facade.GameFacade;
import com.cerp.mvc.GameController;
import com.cerp.mvc.GameView;
import com.cerp.mvc.SwingGameView;

import java.io.InputStream;
import java.util.Properties;

/**
 * Entry point for SQL Escape. Loads the configuration and starts the game.
 */
public class App {
    public static void main(String[] args) {
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

        GameDatabase db_narrativa = GameDatabase.getInstance(url_narrativa, user, pass);
        if (!db_narrativa.connect()) {

            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        GameDatabase db_sqlescape = GameDatabase.getInstance(url_sqlescape, user, pass);
        if (!db_sqlescape.connect()) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        SqlEscapeGame game = new SqlEscapeGame(db_sqlescape);
        PlayerDAO playerDAO = new PlayerDAO(db_narrativa);
        ProgressDAO progressDAO = new ProgressDAO(db_narrativa);
        LevelDAO levelDAO = new LevelDAO(db_narrativa);
        GameFacade facade = new GameFacade(game, playerDAO, progressDAO, levelDAO);
        GameView view = new SwingGameView();

        GameController controller = new GameController(facade, view);

        facade.startGame();
        view.displayMessage("Juego iniciado. ¡Buena suerte!");
        controller.showLevel();

        view.displayMessage("Ingresa tu consulta:");
        String query = view.getUserQuery();
        controller.handleQuery(query);

        game.exitGame();
    }
}

