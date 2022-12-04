package com.niubi.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.niubi.player.impl.PlayerImpl;

public class Player implements PlayerImpl {
    private float x;
    private float y;
    SpriteBatch batch;
    Texture img;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Player() {
        x = 0;
        y = 0;
    }

    public void render() {

    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}
