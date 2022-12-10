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
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            result.set(0, -5);
            result.set(1, 0);
            result.set(2, 1);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            result.set(0, 5);
            result.set(1, 0);
            result.set(2, 2);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            result.set(0, 0);
            result.set(1, 5);
            result.set(2, 3);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            result.set(0, 0);
            result.set(1, -5);
            result.set(2, 4);
        } else {
            result.set(0, 0);
            result.set(1, 0);
            result.set(2, -1);
        }
        return result;

    }
}
