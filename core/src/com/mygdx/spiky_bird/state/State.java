package com.mygdx.spiky_bird.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by commandcentral on 4/18/2017.
 */

public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gameStateManager;
//    private Viewport viewport;

    protected State(GameStateManager gameStateManager) {
        camera = new OrthographicCamera();
        this.gameStateManager
                = gameStateManager;
        mouse = new Vector3();
//        viewport = new FitViewport(800,480);
    }

    protected abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch spriteBatch);

    public abstract void dispose();
}
