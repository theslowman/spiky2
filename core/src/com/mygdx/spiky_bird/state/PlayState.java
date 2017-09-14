package com.mygdx.spiky_bird.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.spiky_bird.SpikyBird;
import com.mygdx.spiky_bird.sprites.BirdAnimation;
import com.mygdx.spiky_bird.sprites.Obstacle;

import java.util.ArrayList;

/**
 * Created by commandcentral on 4/30/2017.
 */

public class PlayState extends State {
    private static final int FIRST_OBSTACLE = 150;
    private static final int OBSTACLE_SPACING = 125;
    private static final int OBSTACLE_COUNT = 4;

    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();

    private Texture background;
    private com.mygdx.spiky_bird.sprites.Bird bird;
    private Obstacle obstacle;
    float time;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("background-city.jpg");
        bird = new com.mygdx.spiky_bird.sprites.Bird(50, 100);
        camera.setToOrtho(false, SpikyBird.WIDTH / 2, SpikyBird.HEIGHT / 2);
        obstacle = new Obstacle(FIRST_OBSTACLE);

        for (int i = 1; i <= OBSTACLE_COUNT; i++) {
            obstacleList.add(new Obstacle(i * (OBSTACLE_SPACING + Obstacle.getTubeWidth())));
        }
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {

        handleInput();
        bird.update(dt);
        Sound sound;

        camera.position.x = bird.getPosition().x + 100;
        for (Obstacle obstacle : obstacleList) {
            if (camera.position.x - (camera.viewportWidth / 2) > obstacle.getPositionTop().x + obstacle.getTop().getWidth()) {
                obstacle.reposition(obstacle.getPositionTop().x + ((Obstacle.getTubeWidth() + OBSTACLE_SPACING) * OBSTACLE_COUNT));
            }

            if (obstacle.collides(bird)) {
                gameStateManager.set(new PlayState(gameStateManager));
            }
        }

        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        time += Gdx.graphics.getDeltaTime();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(BirdAnimation.getInstance().getAnimation().getKeyFrame(time, true), bird.getPosition().x, bird.getPosition().y, 50, 50);
        for (Obstacle obstacle : obstacleList) {
            spriteBatch.draw(obstacle.getTop(), obstacle.getPositionTop().x, obstacle.getPositionTop().y, 50, obstacle.getTop().getHeight());
            spriteBatch.draw(obstacle.getBottom(), obstacle.getPositionBottom().x, obstacle.getPositionBottom().y, 50, obstacle.getBottom().getHeight());
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
