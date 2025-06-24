package com.cerp.state;

import com.cerp.Logger;

/**
 * State when the game has not begun yet.
 */
public class StartState implements GameState {
    @Override
    public void start() {
        Logger.log("StartState.start");
        // Logic for starting the game
    }

    @Override
    public void play() {
        Logger.log("StartState.play");
        // Not applicable in start state
    }

    @Override
    public void end() {
        Logger.log("StartState.end");
        // Not applicable in start state
    }
}
