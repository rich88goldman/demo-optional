package com.example.demooptional;

/**
 * An alliance of any given game session; it has current session's color and also 
 * previous color (if it has gone to more than one session)
 */
public class Alliance {

    private String color;  // getter omitted here
    private String previousColor;

    public String getPreviousColor() {
        return previousColor;
    }

    public Alliance() {}
    
    public Alliance(String previousColor) {
        this.previousColor = previousColor;
    }

    
}
