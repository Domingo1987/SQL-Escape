package com.cerp.sqlescape.db;

import com.cerp.sqlescape.model.PlayerProgress;

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
        return new ArrayList<>();
    }

    public List<PlayerProgress> findByLevel(int levelId) {
        return new ArrayList<>();
    }

    public boolean save(PlayerProgress progress) {
        return false;
    }

    public boolean update(PlayerProgress progress) {
        return false;
    }
}
