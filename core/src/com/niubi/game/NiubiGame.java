package com.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.niubi.map.Map;
import com.niubi.map.impl.MapImpl;
import com.niubi.player.Player;
import com.niubi.player.impl.PlayerImpl;

public class NiubiGame extends ApplicationAdapter {
	Player player;
	Map map;

	@Override
	public void create() {

		player = new PlayerImpl();
		map = new MapImpl();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		map.render();
		player.render();
	}

	@Override
	public void dispose() {
		player.dispose();
		map.dispose();
	}
}
