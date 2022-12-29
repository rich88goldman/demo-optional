package com.example.demooptional;

/**
 * The current match (e.g. Bridgewater) being hosted on FMS; each match will have multiple sessions
 */
public class CurrentMatch {
    
    private ActiveSession activeSession;

    public CurrentMatch(){}

    public CurrentMatch(ActiveSession activeSession) {
        this.activeSession = activeSession;
    }

    public ActiveSession getActiveSession() {
        return activeSession;
    }

    
}
