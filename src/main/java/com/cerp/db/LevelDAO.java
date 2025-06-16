package com.cerp.db;

import com.cerp.model.Challenge;
import com.cerp.model.Level;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DAO for loading levels from the database.
 */
public class LevelDAO {
    private final GameDatabase database;

    public LevelDAO(GameDatabase database) {
        this.database = database;
    }

    public Level findByNumber(int number) {
        String sql = "SELECT id, numero, titulo, narrativa, pregunta FROM NIVEL WHERE numero = " + number + " LIMIT 1";
        try (Statement stmt = database.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                int id = rs.getInt("id");
                Level level = new Level(id, rs.getInt("numero"), rs.getString("titulo"));
                level.setNarrative(rs.getString("narrativa"));
                Challenge ch = new Challenge(id, rs.getString("pregunta"));
                level.setChallenge(ch);
                return level;
            }
        } catch (Exception e) {
            // simplified error handling
        }
        return null;
    }
}
