package lsz.niubi.monster;

import lsz.niubi.config.Storage.Action;

public interface Monster {
    void render();

    void dispose();

    void initJson();

    public void getImageByInfo(Action action, Integer frameNum, Integer direction);

    public void setPostion();
}
