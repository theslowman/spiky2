package com.mygdx.spiky_bird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by commandcentral on 9/4/2017.
 */

public class BirdAnimation {
    private TextureRegion region1 = new TextureRegion(new Texture("bird_1.png"));
    private TextureRegion region2 = new TextureRegion(new Texture("bird_2.png"));
    private TextureRegion region3 = new TextureRegion(new Texture("bird_3.png"));
    private static BirdAnimation birdAnimation;
    Animation<TextureRegion> animation;

    public BirdAnimation() {
        animation = new Animation<TextureRegion>(0.15f, region1, region2, region3);
    }

    public static BirdAnimation getInstance(){
        if (birdAnimation == null){
            birdAnimation = new BirdAnimation();
        }
        return birdAnimation;
    }

    public Animation<TextureRegion> getAnimation(){
        return animation;
    }
}
