package com.niubi.player.impl;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niubi.config.Const.Action;
import com.niubi.player.Player;
import com.niubi.tools.JsonFormat;
import com.niubi.tools.Position;

public class DefaultPlayer implements Player {
    private Position pos;
    private SpriteBatch batch;
    private Texture img;
    private Sprite sp;
    private TextureRegion texture;
    private JsonFormat result;
    private Integer direction;
    private Integer frameNum;

    public DefaultPlayer() {
        direction = 0;
        frameNum = 0;
        pos = new Position();
        batch = new SpriteBatch();
        // load texture
        img = new Texture("img/ba.png");
        sp = new Sprite();
        texture = new TextureRegion(img);
        // load json
        initJson();
        getImageByInfo(Action.Idle, frameNum, direction);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.niubi.player.Player#render()
     */
    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pos.setX(pos.getX() - 5);
            direction = 1;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pos.setX(pos.getX() + 5);
            direction = 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.setY(pos.getY() + 5);
            direction = 3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.setY(pos.getY() - 5);
            direction = 4;
        }
        // draw the background
        ScreenUtils.clear(0, 0, 0, 1);
        getImageByInfo(Action.Idle, frameNum, direction);
        batch.begin();
        sp.draw(batch);
        sp.setPosition(pos.getX(), pos.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.niubi.player.Player#initJson()
     */
    @Override
    public void initJson() {
        FileHandle handle = Gdx.files.internal("assets/json/ba.json");
        // jackson
        ObjectMapper m = new ObjectMapper();
        try {
            result = m.readValue(handle.readString(), JsonFormat.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param action
     * @param frameNum
     */
    @SuppressWarnings("unchecked")
    public void getImageByInfo(Action action, Integer frameNum, Integer direction) {
        StringBuilder builer = new StringBuilder(16);
        builer.append(direction.toString());
        switch (action) {
            case Idle:
                builer.append("_stand_");
                break;
            case Attack:
                builer.append("_attack_");
                break;
            case Run:
                builer.append("_run_");
            default:
                break;

        }
        builer.append(frameNum.toString());
        builer.append(".png");
        Object res = result.getFrames().get(builer.toString()).get("frame");
        Map<String, Number> info = (Map<String, Number>) res;
        texture.setTexture(img);
        texture.setRegion(info.get("x").intValue(),
                info.get("y").intValue(),
                info.get("w").intValue(),
                info.get("h").intValue());
        sp.setRegion(texture);
        sp.setSize(info.get("w").intValue(), info.get("h").intValue());
        sp.setScale(5, 5);
    }

}
