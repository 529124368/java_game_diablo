package lsz.niubi.player;

import com.badlogic.gdx.graphics.g2d.Sprite;

import lsz.niubi.config.Storage.Action;

public interface Player {
    void render();

    void render(int[] controller);

    void dispose();

    Sprite getImageByInfo(Action action, Integer frameNum, Integer direction);

    void setPostion(Sprite sp);
}
