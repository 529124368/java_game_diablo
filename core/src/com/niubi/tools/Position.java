package com.niubi.tools;

public class Position {
    public float x;
    public float y;

    public Position() {
        x = 0.0f;
        y = 0.0f;
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void updatePos(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
