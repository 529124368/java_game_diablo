package com.niubi.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.niubi.config.Define.Action;

public interface Player {
    void render();

    void dispose();

    void initJson();

    public void getImageByInfo(Action action, Integer frameNum, Integer direction);

    public void setPostion();

}
