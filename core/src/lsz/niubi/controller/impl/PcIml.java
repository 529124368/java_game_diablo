package lsz.niubi.controller.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import lsz.niubi.controller.Controller;

public class PcIml implements Controller {

    private int[] result = new int[3];

    @Override
    public int[] getResult() {
        int x = 0;
        int y = 0;
        int dir = -1;
        // 返回 x坐标 y坐标 direction方向 值
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x += -5;
            dir = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += 5;
            dir = 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += 5;
            dir = 3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y += -5;
            dir = 4;
        }
        result[0] = x;
        result[1] = y;
        result[2] = dir;

        return result;
    }

}
