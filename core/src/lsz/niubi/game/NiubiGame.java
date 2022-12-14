package lsz.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.ScreenUtils;

import lsz.niubi.config.Storage;
import lsz.niubi.config.Storage.ControllerType;
import lsz.niubi.config.Storage.GameScence;
import lsz.niubi.controller.Controller;
import lsz.niubi.controller.impl.MobileIml;
import lsz.niubi.controller.impl.PcIml;
import lsz.niubi.map.Map;
import lsz.niubi.map.impl.MapImpl;
import lsz.niubi.player.Player;
import lsz.niubi.player.impl.PlayerImpl;
import lsz.niubi.ui.Ui;

public class NiubiGame extends ApplicationAdapter {
	private int[] res;
	private Player player;
	private Map map;
	private Controller ctl;
	private Ui ui;
	private boolean is_bgm_play = false;
	public static GameScence currentScence = GameScence.Start;
	private Music music;

	@Override
	public void create() {
		// UI
		ui = new Ui();
		// 角色地图加载
		player = new PlayerImpl();
		map = new MapImpl();
		// music
		music = Gdx.audio.newMusic(Gdx.files.internal("music/dtowne.wav"));
		music.setLooping(true);
		// 控制器初始化
		if (Storage.controllerType.equals(ControllerType.PC)) {
			ctl = new PcIml();
		} else {
			ctl = new MobileIml();
		}

	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		switch (currentScence) {
			case Start:
				ui.render();
				break;
			case SelectRooler:
				System.out.println("sdf");
				break;
			case Run:
				if (!is_bgm_play) {
					music.play();
					is_bgm_play = true;
				}
				res = ctl.getResult();
				map.render(res);
				player.render(res);
				ui.render();
				break;
		}

	}

	@Override
	public void resize(int width, int height) {
		ui.resize(width, height);
	}

	@Override
	public void dispose() {
		player.dispose();
		map.dispose();
	}
}
