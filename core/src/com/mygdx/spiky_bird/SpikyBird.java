package com.mygdx.spiky_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.spiky_bird.map.MapGrid;
import com.mygdx.spiky_bird.state.GameStateManager;
import com.mygdx.spiky_bird.state.MenuState;

public class SpikyBird extends Game {
    public static int WIDTH;
    public static int HEIGHT;

    public static final String TITLE = "StatkiGame";
    private GameStateManager gameStateManager;
    private SpriteBatch spriteBatch;
    public ShapeRenderer renderer;

    MapGrid grid;

    Texture img;

    @Override
    public void create() {

        WIDTH = Gdx.app.getGraphics().getWidth();
        HEIGHT = Gdx.app.getGraphics().getHeight();


        spriteBatch = new SpriteBatch();
        gameStateManager = new GameStateManager();
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        gameStateManager.push(new MenuState(gameStateManager));
//        grid = new MapGrid(10,10);

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.render(spriteBatch);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        img.dispose();

        gameStateManager.render(spriteBatch);
    }
}
