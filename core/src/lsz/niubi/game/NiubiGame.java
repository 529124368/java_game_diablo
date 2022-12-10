package lsz.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import lsz.niubi.config.Storage;
import lsz.niubi.config.Storage.ControllerType;
import lsz.niubi.controller.Controller;
import lsz.niubi.controller.impl.MobileIml;
import lsz.niubi.controller.impl.PcIml;
import lsz.niubi.map.Map;
import lsz.niubi.map.impl.MapImpl;
import lsz.niubi.player.Player;
import lsz.niubi.player.impl.PlayerImpl;

public class NiubiGame extends ApplicationAdapter {
	private int[] res;
	private Player player;
	private Map map;
	private Controller ctl;

	private Viewport viewport;
	private Camera camera;

	@Override
	public void create() {
		camera = new PerspectiveCamera();
		viewport = new FitViewport(Storage.ScreenWidth, Storage.ScreenHeight, camera);
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

	public void resize(int width, int height) {
		viewport.update(width, height);
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
