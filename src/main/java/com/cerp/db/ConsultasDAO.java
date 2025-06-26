package com.cerp.db;

import com.cerp.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for loading expected queries for challenges from the database.
 */
public class ConsultasDAO {
    private final GameDatabase database;

    public ConsultasDAO(GameDatabase database) {
        Logger.log("ConsultasDAO.<init>");
        this.database = database;
    }

    /**
     * Finds all expected queries for a specific level
     * @param levelId the level ID to search for
     * @return list of expected SQL queries
     */
    public List<String> findByLevelId(int levelId) {
        Logger.log("ConsultasDAO.findByLevelId llamado con levelId = " + levelId);

        List<String> consultas = new ArrayList<>();

        if (database == null || !database.isConnected()) {
            Logger.logError("Base de datos no conectada");
            return consultas;
        }

        String sql = "SELECT consulta FROM CONSULTA WHERE nivel_id = " + levelId;
        Logger.log("Ejecutando SQL: " + sql);

        try (Statement stmt = database.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String consulta = rs.getString("consulta");
                consultas.add(consulta);
                Logger.log("Consulta encontrada: " + consulta);
            }

            Logger.log("Total consultas encontradas: " + consultas.size());

        } catch (Exception e) {
            Logger.logError("Error en findByLevelId: " + e.getMessage());
            e.printStackTrace();
        }

        return consultas;
    }

    /**
     * Finds the primary/first expected query for a level
     * @param levelId the level ID
     * @return the primary expected query or null if not found
     */
    public String findPrimaryQueryByLevelId(int levelId) {
        Logger.log("ConsultasDAO.findPrimaryQueryByLevelId llamado con levelId = " + levelId);

        List<String> consultas = findByLevelId(levelId);
        return consultas.isEmpty() ? null : consultas.get(0);
    }
}