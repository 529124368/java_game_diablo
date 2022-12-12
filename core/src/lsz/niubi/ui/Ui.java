package lsz.niubi.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
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

        final Image image1, image2;
        image1 = new Image(skin, "char_cel");
        image1.setVisible(false);
        table.add(image1).padRight(-300.0f).padBottom(28.0f);

        image2 = new Image(skin, "inv_cel");
        image2.setVisible(false);
        table.add(image2).padRight(-610.0f).padBottom(30.0f).align(Align.right);

        table.row();

        // 装备物件
        final Container container1, container2, container3, container4, container5, container6, container7;

        container1 = new Container();
        Image image = new Image(skin, "objcurs_cel_frame0117");
        container1.setActor(image);
        table.add(container1).padRight(-800.0f).padTop(-530.0f);

        container2 = new Container();

        image = new Image(skin, "objcurs_cel_frame0118");
        container2.setActor(image);
        table.add(container2).padRight(-900.0f).padTop(-530.0f);

        container3 = new Container();

        image = new Image(skin, "objcurs_cel_frame0109");
        container3.setActor(image);
        table.add(container3).padRight(-865.0f).padTop(-705.0f);

        container4 = new Container();

        image = new Image(skin, "objcurs_cel_frame0055");
        container4.setActor(image);
        table.add(container4).padRight(-815.0f).padTop(-670.0f);

        container5 = new Container();

        image = new Image(skin, "objcurs_cel_frame0159");
        container5.setActor(image);
        table.add(container5).padRight(-805.0f).padTop(-530.0f);

        container6 = new Container();

        image = new Image(skin, "objcurs_cel_frame0029");
        container6.setActor(image);
        table.add(container6).padRight(-777.0f).padTop(-380.0f);

        container7 = new Container();

        image = new Image(skin, "objcurs_cel_frame0018");
        container7.setActor(image);
        table.add(container7).padRight(-380.0f).padTop(-380.0f);

        final ArrayList<Container> eqlist = new ArrayList<>();
        eqlist.add(container1);
        eqlist.add(container2);
        eqlist.add(container3);
        eqlist.add(container4);
        eqlist.add(container5);
        eqlist.add(container6);
        eqlist.add(container7);
        for (Container eq : eqlist) {
            eq.setVisible(false);
        }

        table.row();
        image = new Image(skin, "0000");
        table.add(image);

        image = new Image(skin, "HP");
        table.add(image).padLeft(-117.0f).padBottom(13.0f).align(Align.bottom);

        image = new Image(skin, "chisha");
        table.add(image).padLeft(-11.0f).align(Align.bottom);

        image = new Image(skin, "0001");
        table.add(image);

        // #######START######## 跑步切换按钮
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
        // ######END######### 跑步切换按钮

        ImageButton imageButton = new ImageButton(skin);
        table.add(imageButton).padLeft(-145.0f).padBottom(9.0f).align(Align.bottom);

        image = new Image(skin, "0002");
        table.add(image);

        // ######START MenuBar ########
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
        // ######END########

        image = new Image(skin, "0003");
        table.add(image);

        image = new Image(skin, "0004");
        table.add(image);

        imageButton = new ImageButton(skin);
        table.add(imageButton).padLeft(-195.0f).padBottom(9.0f).align(Align.bottom);

        image = new Image(skin, "spelicon_cel_frame0030");
        table.add(image).padLeft(-42.0f).align(Align.bottom).prefHeight(48.0f);

        image = new Image(skin, "00055");
        table.add(image);

        image = new Image(skin, "MP");
        table.add(image).padLeft(-135.0f).padBottom(13.0f).align(Align.bottom);

        table.row();

        image = new Image(skin, "miniPanel");
        stack.addActor(image);

        Table table1 = new Table();

        Button button = new Button(skin, "menu1");
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (image1.isVisible()) {
                    image1.setVisible(false);
                } else {
                    image1.setVisible(true);
                }
            }
        });
        table1.add(button);

        button = new Button(skin, "menu2");
        button.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (image2.isVisible()) {
                    image2.setVisible(false);
                    for (Container v : eqlist) {
                        v.setVisible(false);
                    }
                } else {
                    image2.setVisible(true);
                    for (Container v : eqlist) {
                        v.setVisible(true);
                    }
                }
            }
        });
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
