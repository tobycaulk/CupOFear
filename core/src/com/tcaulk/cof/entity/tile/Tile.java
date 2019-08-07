package com.tcaulk.cof.entity.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Tile {

    public static final TileGrass GRASS = new TileGrass();
    public static final TileGrassFlower GRASS_FLOWER = new TileGrassFlower();
    public static final TileOvergrownGrass OVERGROWN_GRASS = new TileOvergrownGrass();

    private TextureRegion texture;
    private int width;
    private int height;
    boolean isCollidable;

    public Tile(TextureRegion texture, int width, int height, boolean isCollidable) {
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.isCollidable = isCollidable;
    }

    public void render(SpriteBatch batch, int x, int y) {
        batch.draw(texture, x, y, width, height);
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public void setTexture(TextureRegion texture) {
        this.texture = texture;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        isCollidable = collidable;
    }
}