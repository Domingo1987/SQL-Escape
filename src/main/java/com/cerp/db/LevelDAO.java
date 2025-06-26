package com.cerp.db;

import com.cerp.model.Challenge;
import com.cerp.model.Level;
import com.cerp.Logger;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * DAO for loading levels from the database.
 */
public class LevelDAO {
    private final GameDatabase database;
    private final ConsultasDAO consultasDAO;

    public LevelDAO(GameDatabase database) {
        Logger.log("LevelDAO.<init>");
        this.database = database;
        this.consultasDAO = new ConsultasDAO(database);
    }

    public Level findByNumber(int number) {
        Logger.log("LevelDAO.findByNumber llamado con number = " + number);

        // Comprobando conexión a la base de datos
        if (database == null) {
            Logger.logError("database es null");
            return null;
        }
        if (!database.isConnected()) {
            Logger.logError("la base de datos NO está conectada");
            return null;
        }

        String sql = "SELECT id, numero, titulo, narrativa, pregunta, feedback FROM NIVEL WHERE numero = " + number + " LIMIT 1";
        Logger.log("Ejecutando SQL: " + sql);

        try (Statement stmt = database.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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
                level.setFeedback(rs.getString("feedback"));

                // Crear challenge con la pregunta
                Challenge challenge = new Challenge(id, rs.getString("pregunta"));

                // Cargar las consultas esperadas usando ConsultasDAO
                Logger.log("Cargando consultas esperadas para nivel ID: " + id);
                List<String> consultasEsperadas = consultasDAO.findByLevelId(id);

                if (!consultasEsperadas.isEmpty()) {
                    challenge.setExpectedQueries(consultasEsperadas);
                    Logger.log("Se cargaron " + consultasEsperadas.size() + " consultas esperadas");
                    Logger.log("Consulta principal: " + challenge.getExpectedQuery());
                } else {
                    Logger.log("ADVERTENCIA: No se encontraron consultas esperadas para el nivel " + number);
                }

                // Configurar puntos por defecto (esto podría venir de la BD también)
                challenge.setPoints(100);

                level.setChallenge(challenge);

                Logger.log("Level creado exitosamente: " + level);
                return level;

            } else {
                Logger.log("No se encontró ningún nivel con numero = " + number);
            }
        } catch (Exception e) {
            Logger.logError("Error en findByNumber: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}