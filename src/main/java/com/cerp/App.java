package com.cerp;

import com.cerp.SqlEscapeGame;
import com.cerp.db.GameDatabase;
import com.cerp.db.PlayerDAO;
import com.cerp.db.ProgressDAO;
import com.cerp.facade.GameFacade;
import com.cerp.mvc.GameController;
import com.cerp.mvc.GameView;

import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 * Entry point for SQL Escape. Loads the configuration and starts the game.
 */
public class App
{
    public static void main(String[] args) {
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

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String pass = props.getProperty("password");

        GameDatabase db = GameDatabase.getInstance(url, user, pass);
        if (!db.connect()) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        SqlEscapeGame game = new SqlEscapeGame(db);
        PlayerDAO playerDAO = new PlayerDAO(db);
        ProgressDAO progressDAO = new ProgressDAO(db);
        GameFacade facade = new GameFacade(game, playerDAO, progressDAO);
        GameView view = new GameView();
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