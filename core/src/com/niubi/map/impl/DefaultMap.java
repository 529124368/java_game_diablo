package com.niubi.map.impl;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.niubi.map.Map;

public class DefaultMap implements Map {
    private Vector2 pos = new Vector2(-1200, -450);
    private SpriteBatch batch = new SpriteBatch();;
    private Sprite sp;
    private AssetManager manager;
    private boolean hasNew = false;

    public DefaultMap() {
        // load texture
        manager = new AssetManager();
        manager.load("map/map.png", Texture.class);
    }

    @Override
    public final void render() {

        if (manager.update()) {
            if (!hasNew) {
                sp = new Sprite((Texture) manager.get("map/map.png"));
                sp.setPosition(pos.x, pos.y);
                hasNew = true;
            }
            batch.begin();
            sp.draw(batch);
            batch.end();
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        manager.dispose();
    }

}
