package lsz.niubi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

import lsz.niubi.config.Storage;

public class Ui {
    private Stage stage;
    private Skin skin;

    public Ui() {
        stage = new Stage(new FitViewport(Storage.ScreenWidth, Storage.ScreenHeight));
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

        final Button run, run_down;
        run = new Button(skin, "run");
        run_down = new Button(skin, "run_ok");
        run_down.setVisible(false);
        run.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                run_down.setVisible(true);
                run.setVisible(false);
            }

        });
        run_down.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                run_down.setVisible(false);
                run.setVisible(true);
            }

        });
        table.add(run).padLeft(-60.0f).padBottom(10.0f).align(Align.bottom);
        table.add(run_down).padLeft(-60.0f).padBottom(10.0f).align(Align.bottom);

        ImageButton imageButton = new ImageButton(skin);
        table.add(imageButton).padLeft(-145.0f).padBottom(9.0f).align(Align.bottom);

        image = new Image(skin, "0002");
        table.add(image);

        final Stack stack = new Stack();
        stack.setVisible(false);
        final Button button1, button2;
        button1 = new Button(skin, "xiala");
        button2 = new Button(skin, "shangla");
        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                button2.setVisible(true);
                button1.setVisible(false);
                stack.setVisible(true);
            }
        });
        table.add(button1).padLeft(-42.0f).padBottom(-46.0f);

        button2.setVisible(false);
        button2.addListener(new ClickListener() {
            // 匿名内部类
            @Override
            public void clicked(InputEvent event, float x, float y) {
                button2.setVisible(false);
                button1.setVisible(true);
                stack.setVisible(false);
            }

        });
        table.add(button2).padLeft(-42.0f).padBottom(-46.0f);

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

        table.row();

        image = new Image(skin, "miniPanel");
        stack.addActor(image);

        Table table1 = new Table();

        Button button = new Button(skin, "menu1");
        table1.add(button);

        button = new Button(skin, "menu2");
        table1.add(button);

        button = new Button(skin, "menu3");
        table1.add(button);

        button = new Button(skin, "menu4");
        table1.add(button);

        button = new Button(skin, "menu5");
        table1.add(button);

        button = new Button(skin, "menu6");
        table1.add(button);

        button = new Button(skin, "menu7");
        table1.add(button);
        stack.addActor(table1);
        table.add(stack).padRight(-666.0f).padTop(-130.0f).prefWidth(0.0f);
        stage.addActor(table);

    }

    public void render() {
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

}