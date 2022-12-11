package lsz.niubi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

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
	private Skin skin;

	private Stage stage;

	@Override
	public void create() {
		stage = new Stage(new FitViewport(Storage.ScreenWidth, Storage.ScreenHeight));
		// 角色地图加载
		player = new PlayerImpl();
		map = new MapImpl();

		// 控制器初始化
		if (Storage.controllerType.equals(ControllerType.PC)) {
			ctl = new PcIml();
		} else {
			ctl = new MobileIml();
		}

		skin = new Skin(Gdx.files.internal("ui/bar.json"));
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.align(Align.bottom);
		table.setFillParent(true);

		Image image = new Image(skin, "0000");
		table.add(image);

		image = new Image(skin, "HP");
		table.add(image).padLeft(-117.0f).padBottom(13.0f).align(Align.bottom);

		image = new Image(skin, "chisha");
		table.add(image).padLeft(-11.0f).align(Align.bottom);

		image = new Image(skin, "0001");
		table.add(image);

		ImageButton imageButton = new ImageButton(skin);
		table.add(imageButton).padLeft(-145.0f).padBottom(9.0f).align(Align.bottom);

		image = new Image(skin, "0002");
		table.add(image);

		Button button = new Button(skin, "xiala");
		table.add(button).padLeft(-42.0f).padBottom(-46.0f);

		image = new Image(skin, "0003");
		table.add(image);

		image = new Image(skin, "0004");
		table.add(image);

		imageButton = new ImageButton(skin);
		table.add(imageButton).padLeft(-195.0f).padBottom(9.0f).align(Align.bottom);

		image = new Image(skin, "liehuo");
		table.add(image).padLeft(-42.0f).align(Align.bottom);

		image = new Image(skin, "00055");
		table.add(image);

		image = new Image(skin, "MP");
		table.add(image).padLeft(-135.0f).padBottom(13.0f).align(Align.bottom);
		stage.addActor(table);
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void render() {
		res = ctl.getResult();
		ScreenUtils.clear(0, 0, 0, 1);
		map.render(res);
		player.render(res);
		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		player.dispose();
		map.dispose();
	}
}
