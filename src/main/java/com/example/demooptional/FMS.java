package com.example.demooptional;

/**
 * The FRC game's Field Management System
 */
public class FMS {

    private static FMS fms = new FMS();
    
    private FMS(){}
    public static FMS defaultInstance(){
        return fms;
    }

    private CurrentMatch currentMatch;

    public CurrentMatch getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentMatch(CurrentMatch currentMatch) {
        this.currentMatch = currentMatch;
    }

    


}
