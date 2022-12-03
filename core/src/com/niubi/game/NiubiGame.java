package com.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.niubi.player.Player;

public class NiubiGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Player player;

	@Override
	public void create() {
		player = new Player();
		batch = new SpriteBatch();
		img = new Texture("img/badlogic.jpg");

	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.setX(player.getX() - 5);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.setX(player.getX() + 5);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player.setY(player.getY() + 5);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.setY(player.getY() - 5);
		}
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, player.getX(), player.getY());
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
