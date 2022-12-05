package com.niubi.tools;

public class Position {
    private float x;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    private float y;

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Position() {
        x = 0.0f;
        y = 0.0f;
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
