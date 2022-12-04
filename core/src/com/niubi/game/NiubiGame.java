package com.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.niubi.player.Player;
import com.niubi.player.impl.DefaultPlayer;

public class NiubiGame extends ApplicationAdapter {
	Player player;

	@Override
	public void create() {
		player = new DefaultPlayer();
	}

	@Override
	public void render() {
		player.render();
	}

	@Override
	public void dispose() {
		player.dispose();
	}
}
