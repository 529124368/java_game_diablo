package lsz.niubi.player.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.math.Vector2;

import lsz.niubi.config.Storage;
import lsz.niubi.config.Storage.Action;
import lsz.niubi.player.Player;

public class PlayerImpl implements Player {
    private Vector2 pos = new Vector2(Storage.ScreenWidth / 2, Storage.ScreenHeight / 2);;
    private SpriteBatch batch = new SpriteBatch();;

    private int direction, frameNum, currentFrame;
    private StringBuilder builer = new StringBuilder(16);
    private float delta = 0.0f;
    private Action currentAction = Action.Idle;

    private TextureAtlas atlas;

    public PlayerImpl() {

        direction = 5;
        frameNum = 0;
        currentFrame = Storage.IdleFrame;

        atlas = new TextureAtlas(Gdx.files.internal("img/ba"));

        getImageByInfo(currentAction, frameNum, direction);

    }

    @Override
    public final void render() {
        delta += Gdx.graphics.getDeltaTime();
        if (delta > 0.1f) {
            delta = 0.0f;
            frameNum++;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            if (currentAction == Action.Idle) {
                currentAction = Action.Run;
                currentFrame = Storage.RunFrame;
            } else {
                currentAction = Action.Idle;
                currentFrame = Storage.IdleFrame;
            }
        }
        // get Image
        Sprite sp = getImageByInfo(currentAction, frameNum, direction);
        setPostion(sp);
        // draw
        batch.begin();
        sp.draw(batch);
        batch.end();
    }

    public final void render(int[] controller) {
        delta += Gdx.graphics.getDeltaTime();
        if (delta > 0.1f) {
            delta = 0.0f;
            frameNum++;
        }
        if (controller[2] != -1) {
            direction = controller[2];
        }

        // get Image
        Sprite sp = getImageByInfo(currentAction, frameNum, direction);
        setPostion(sp);
        // draw
        batch.begin();
        sp.draw(batch);
        batch.end();
    }

    @Override
    public final Sprite getImageByInfo(Action action, Integer frameNum, Integer direction) {
        builer.delete(0, builer.length());
        builer.append(direction.toString());
        switch (action) {
            case Idle:
                builer.append("_stand");
                currentFrame = Storage.IdleFrame;
                break;
            case Attack:
                builer.append("_attack");
                break;
            case Run:
                builer.append("_run");
                currentFrame = Storage.RunFrame;
            default:
                break;
        }
        frameNum %= currentFrame;
        return atlas.createSprite(builer.toString(), frameNum);
    }

    @Override
    public final void setPostion(Sprite sp) {
        sp.setPosition(pos.x, pos.y);
        sp.setScale(1.5f, 1.5f);
    }

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
    }
}
