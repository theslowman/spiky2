package com.mygdx.spiky_bird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by commandcentral on 8/13/2017.
 */

public class Obstacle {
    private static final int FLUCTUATION = 20;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private static final int SIZE = 120;
    private static Texture top, bottom;
    private static String texturePathTop = "spike_D_top.png", texturePathBottom = "spike_D.png";
    private Random rand;
    private Vector2 positionTop, positionBottom;
    private static int obstacleWidth;
    public Rectangle boundTop, boundBottom;

    public Rectangle getBoundTop() {
        return boundTop;
    }

    public void setBoundTop(Rectangle boundTop) {
        this.boundTop = boundTop;
    }

    public Rectangle getBoundBottom() {
        return boundBottom;
    }

    public void setBoundBottom(Rectangle boundBottom) {
        this.boundBottom = boundBottom;
    }

    public Obstacle(float x) {
        top = new Texture(texturePathTop);
        bottom = new Texture(texturePathBottom);
        rand = new Random();

        obstacleWidth = top.getWidth();

        positionTop = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        positionBottom = new Vector2(x, positionTop.y - TUBE_GAP - top.getHeight());

        boundTop = new Rectangle(positionTop.x, positionTop.y, 50, top.getHeight());
        boundBottom = new Rectangle(positionBottom.x, positionBottom.y, 50, bottom.getHeight());
    }

    public Texture getTop() {
        return top;
    }

    public Texture getBottom() {
        return bottom;
    }

    public Vector2 getPositionTop() {
        return positionTop;
    }

    public Vector2 getPositionBottom() {
        return positionBottom;
    }

    public void reposition(float x) {
        positionTop.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        positionBottom.set(x, positionTop.y - TUBE_GAP - top.getHeight());
        boundTop.setPosition(positionTop.x, positionTop.y);
        boundBottom.setPosition(positionBottom.x, positionBottom.y);
    }

    public static int getTubeWidth() {
        return top.getWidth();
    }

    public boolean collides(Bird bird) {

        if (Intersector.overlaps(bird.getBounds(), boundBottom)){
//            System.out.println("top");
//            System.out.println("Bird: "+bird.getBounds());
//            System.out.println("Bottom:"+ boundBottom);
//            System.out.println("Top:"+ boundTop);
        }
        if (Intersector.overlaps(bird.getBounds(), boundTop)){
//            System.out.println("top");
//            System.out.println("Bird: "+bird.getBounds());
//            System.out.println("Bottom:"+ boundBottom);
//            System.out.println("Top:"+ boundTop);
        }
        return Intersector.overlaps(bird.getBounds(), boundBottom) || Intersector.overlaps(bird.getBounds(), boundTop);
    }
}
