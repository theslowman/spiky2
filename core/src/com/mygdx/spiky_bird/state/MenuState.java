package com.mygdx.spiky_bird.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by commandcentral on 4/30/2017.
 */

public class MenuState extends State {
    private Texture background;
    private Texture startButton;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("background-city.jpg");
        startButton = new Texture("blue-button.png");

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            System.out.println("lala");
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, com.mygdx.spiky_bird.SpikyBird.WIDTH, com.mygdx.spiky_bird.SpikyBird.HEIGHT);
        spriteBatch.draw(startButton, (com.mygdx.spiky_bird.SpikyBird.WIDTH / 2) - (startButton.getWidth() / 2),
                (com.mygdx.spiky_bird.SpikyBird.HEIGHT / 2) - (startButton.getHeight() / 2));
        spriteBatch.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        startButton.dispose();
    }
}
