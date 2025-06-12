package com.cerp.state;

/**
 * State representing an active game session.
 */
public class PlayingState implements GameState {
    @Override
    public void start() {
        // Already started
    }

    @Override
    public void play() {
        // Handle gameplay behaviour
    }

    @Override
    public void end() {
        // Logic to finish the game
    }
}
