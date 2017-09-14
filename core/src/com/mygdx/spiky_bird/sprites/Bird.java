package com.mygdx.spiky_bird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.spiky_bird.birdBehaviour.BirdBehaviour;

/**
 * Created by commandcentral on 8/6/2017.
 */

public class Bird {
    private static final int GRAVITY = -15;

    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Circle bounds;
    private BirdBehaviour birdBehaviour;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird_1.png");
        bounds = new Circle(x, y, 50 / 2);
    }

    public void update(float dt) {
        if (velocity.y>0){
            BirdAnimation.getInstance().getAnimation().setFrameDuration(0.1f);
        } else BirdAnimation.getInstance().getAnimation().setFrameDuration(0.3f);
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }
        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void jump() {
        velocity.y = 200;
    }

    public Circle getBounds(){
        return bounds;
    }
}
