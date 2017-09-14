package com.mygdx.spiky_bird.map;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by commandcentral on 6/11/2017.
 */

public class MapGrid {

    public static final int CELL_SIZE = 50;
    public boolean mapGrid[][];
    public int mapWidth, mapHeight;

    public MapGrid(int width, int height) {
        mapGrid = new boolean[width][height];
        mapWidth = width * CELL_SIZE;
        mapHeight = height * CELL_SIZE;
    }

    public void render(ShapeRenderer renderer) {
        for (int x = 0; x <mapWidth; x += CELL_SIZE)
            for (int y = 0; y < mapHeight; y += CELL_SIZE) {
                renderer.line(x, 0, x, mapHeight);
                renderer.line(0, y, mapWidth, y);
            }
    }
}
