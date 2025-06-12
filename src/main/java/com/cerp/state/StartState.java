package com.cerp.state;

/**
 * State when the game has not begun yet.
 */
public class StartState implements GameState {
    @Override
    public void start() {
        // Logic for starting the game
    }

    @Override
    public void play() {
        // Not applicable in start state
    }

    @Override
    public void end() {
        // Not applicable in start state
    }
}
