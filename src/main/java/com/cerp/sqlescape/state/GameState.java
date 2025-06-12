package com.cerp.sqlescape.state;

/**
 * Base interface for the State pattern. Each game state handles the
 * behaviour of the game depending on the current phase.
 */
public interface GameState {
    void start();
    void play();
    void end();
}
