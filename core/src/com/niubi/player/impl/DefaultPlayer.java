package com.niubi.player.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.niubi.player.Player;
import com.niubi.tools.Position;

public class DefaultPlayer implements Player {
    private Position pos;
    SpriteBatch batch;
    Texture img;

    public DefaultPlayer() {
        pos = new Position();
        batch = new SpriteBatch();
        img = new Texture("img/badlogic.jpg");
    }

    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pos.x = pos.x - 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pos.x = pos.x + 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y = pos.y + 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y = pos.y - 5;
        }
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}
