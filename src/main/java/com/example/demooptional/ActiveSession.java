package com.example.demooptional;

/**
 * Current game session being run at the match
 */
public class ActiveSession {

    private Alliance winningAlliance;

    public ActiveSession(){}

    public ActiveSession(Alliance winningAlliance) {
        this.winningAlliance = winningAlliance;
    }

    public Alliance getWinningAlliance() {
        return winningAlliance;
    }

}
