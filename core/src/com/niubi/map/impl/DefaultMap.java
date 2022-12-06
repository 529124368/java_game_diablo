package com.niubi.map.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.niubi.map.Map;

public class DefaultMap implements Map {
    private Vector2 pos = new Vector2(-1200, -200);
    private SpriteBatch batch = new SpriteBatch();;
    private Texture img;
    private Sprite sp;

    public DefaultMap() {
        // load texture
        img = new Texture("map/map.png");
        sp = new Sprite(img);
        sp.setPosition(pos.x, pos.y);

    }

    @Override
    public final void render() {

        batch.begin();
        sp.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}
