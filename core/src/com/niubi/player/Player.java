package com.niubi.player;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.niubi.config.Define.Action;

public interface Player {
    void render();

    void render(List<Number> controller);

    void dispose();

    Sprite getImageByInfo(Action action, Integer frameNum, Integer direction);

    void setPostion(Sprite sp);
}
