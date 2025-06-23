package com.cerp.db;

import com.cerp.model.PlayerProgress;
import com.cerp.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO for player progress persistence.
 */
public class ProgressDAO {
    private GameDatabase database;

    public ProgressDAO(GameDatabase database) {
        this.database = database;
    }

    public List<PlayerProgress> findByPlayer(int playerId) {
        Logger.log("ProgressDAO.findByPlayer");
        return new ArrayList<>();
    }

    public List<PlayerProgress> findByLevel(int levelId) {
        Logger.log("ProgressDAO.findByLevel");
        return new ArrayList<>();
    }

    public boolean save(PlayerProgress progress) {
        Logger.log("ProgressDAO.save");
        return false;
    }

    public boolean update(PlayerProgress progress) {
        Logger.log("ProgressDAO.update");
        return false;
    }
}
