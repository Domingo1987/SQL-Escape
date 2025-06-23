package com.cerp.db;

import com.cerp.model.Challenge;
import com.cerp.model.Level;
import com.cerp.Logger;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DAO for loading levels from the database.
 */
public class LevelDAO {
    private final GameDatabase database;

    public LevelDAO(GameDatabase database) {

        Logger.log("LevelDAO.<init>");

        this.database = database;
    }

    public Level findByNumber(int number) {
        Logger.log("LevelDAO.findByNumber llamado con number = " + number);

        // Comprobando conexión a la base de datos
        if (database == null) {
            Logger.log("ERROR: database es null");
            return null;
        }
        if (!database.isConnected()) {
            Logger.log("ERROR: la base de datos NO está conectada");
            return null;
        }

        String sql = "SELECT id, numero, titulo, narrativa, pregunta FROM NIVEL WHERE numero = " + number + " LIMIT 1";
        Logger.log("Ejecutando SQL: " + sql);

        try (
                Statement stmt = database.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            Logger.log("Consulta ejecutada, procesando resultados...");

            if (rs.next()) {
                Logger.log("Fila encontrada en la consulta");
                int columnas = rs.getMetaData().getColumnCount();
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= columnas; i++) {
                    sb.append(rs.getMetaData().getColumnName(i)).append(": ")
                            .append(rs.getString(i)).append(" | ");
                }
                Logger.log("Datos obtenidos: " + sb);

                int id = rs.getInt("id");
                Level level = new Level(id, rs.getInt("numero"), rs.getString("titulo"));
                level.setNarrative(rs.getString("narrativa"));
                Challenge ch = new Challenge(id, rs.getString("pregunta"));
                level.setChallenge(ch);

                Logger.log("Level creado: " + level);

                return level;
            } else {
                Logger.log("No se encontró ningún nivel con numero = " + number);
            }
        } catch (Exception e) {
            Logger.log("ERROR en findByNumber: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
