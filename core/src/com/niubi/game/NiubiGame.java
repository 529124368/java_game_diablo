package com.niubi.game;

import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.niubi.config.Storage;
import com.niubi.config.Storage.ControllerType;
import com.niubi.controller.Controller;
import com.niubi.controller.impl.MobileIml;
import com.niubi.controller.impl.PcIml;
import com.niubi.map.Map;
import com.niubi.map.impl.MapImpl;
import com.niubi.player.Player;
import com.niubi.player.impl.PlayerImpl;

public class NiubiGame extends ApplicationAdapter {
	private int[] res;
	private Player player;
	private Map map;
	private Controller ctl;

	@Override
	public void create() {
		// 角色地图加载
		player = new PlayerImpl();
		map = new MapImpl();

		// 控制器初始化
		if (Storage.controllerType.equals(ControllerType.PC)) {
			ctl = new PcIml();
		} else {
			ctl = new MobileIml();
		}
	}

	@Override
	public void render() {
		res = ctl.getResult();
		ScreenUtils.clear(0, 0, 0, 1);
		map.render(res);
		player.render(res);
	}

	@Override
	public void dispose() {
		player.dispose();
		map.dispose();
	}
}
