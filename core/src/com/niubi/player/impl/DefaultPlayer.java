package com.niubi.player.impl;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niubi.config.Define;
import com.niubi.config.Define.Action;
import com.niubi.player.Player;
import com.niubi.tools.JsonFormat;

public class DefaultPlayer implements Player {
    private Vector2 pos = new Vector2(Define.ScreenWidth / 2, Define.ScreenHeight / 2);;
    private SpriteBatch batch = new SpriteBatch();;
    private Texture img;
    private Sprite sp;
    private TextureRegion texture;
    private JsonFormat result;
    private Integer direction, frameNum, currentFrame;
    private StringBuilder builer = new StringBuilder(16);
    private float delta;
    private Action currentAction = Action.Idle;

    public DefaultPlayer() {
        // init variables
        delta = 0.0f;
        direction = 5;
        frameNum = 0;
        currentFrame = Define.IdleFrame;
        // load texture
        img = new Texture("img/ba.png");
        sp = new Sprite();
        texture = new TextureRegion(img);
        // load json
        initJson();
        getImageByInfo(currentAction, frameNum, direction);
    }

    @Override
    public void render() {
        delta += Gdx.graphics.getDeltaTime();
        if (delta > 0.1f) {
            delta = 0.0f;
            frameNum++;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pos.x = pos.x - 5;
            direction = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pos.x = pos.x + 5;
            direction = 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y = pos.y + 5;
            direction = 3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y = pos.y - 5;
            direction = 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            if (currentAction == Action.Idle) {
                currentAction = Action.Run;
                currentFrame = Define.RunFrame;
            } else {
                currentAction = Action.Idle;
                currentFrame = Define.IdleFrame;
            }
        }
        // draw the background
        batch.begin();
        // get Image
        getImageByInfo(currentAction, frameNum, direction);
        sp.draw(batch);
        batch.end();
        // draw pos
        setPostion();

    }

    @Override
    public void initJson() {
        FileHandle handle = Gdx.files.internal("json/ba.json");
        // jackson
        ObjectMapper m = new ObjectMapper();
        try {
            result = m.readValue(handle.readString(), JsonFormat.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void getImageByInfo(Action action, Integer frameNum, Integer direction) {
        builer.delete(0, builer.length());
        builer.append(direction.toString());
        switch (action) {
            case Idle:
                builer.append("_stand_");
                currentFrame = Define.IdleFrame;
                break;
            case Attack:
                builer.append("_attack_");
                break;
            case Run:
                builer.append("_run_");
                currentFrame = Define.RunFrame;
            default:
                break;
        }
        frameNum %= currentFrame;
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
        sp.setSize(info.get("w").floatValue(), info.get("h").floatValue());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setPostion() {
        Object offset = result.getFrames().get(builer.toString()).get("spriteSourceSize");
        Map<String, Number> offsets = (Map<String, Number>) offset;

        sp.setPosition(offsets.get("x").floatValue(), offsets.get("y").floatValue());
        sp.setOriginCenter();
        sp.setScale(1.5f, 1.5f);
        sp.setOriginBasedPosition(pos.x,
                pos.y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
