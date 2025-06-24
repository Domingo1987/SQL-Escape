package com.cerp.state;

import com.cerp.Logger;

/**
 * State representing an active game session.
 */
public class PlayingState implements GameState {
    @Override
    public void start() {
        Logger.log("PlayingState.start");
        // Already started
    }

    @Override
    public void play() {
        Logger.log("PlayingState.play");
        // Handle gameplay behaviour
    }

    @Override
    public void end() {
        Logger.log("PlayingState.end");
        // Logic to finish the game
    }
}
