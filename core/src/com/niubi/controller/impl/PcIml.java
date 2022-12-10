package com.niubi.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.niubi.controller.Controller;

public class PcIml implements Controller {

    private List<Number> result = new ArrayList<>(3);

    public PcIml() {
        result.add(0);
        result.add(0);
        result.add(0);
    }

    @Override
    public List<Number> getResult() {
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
        result.set(0, x);
        result.set(1, y);
        result.set(2, dir);

        return result;
    }

}
