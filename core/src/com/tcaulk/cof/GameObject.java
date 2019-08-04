package com.tcaulk.cof;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    protected Vector2 position;
    protected Vector2 velocity;
    protected float movementSpeed;
    protected int width;
    protected int height;
    protected boolean isCollidable;

    public GameObject(Vector2 position, int width, int height, boolean isCollidable, float movementSpeed) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.isCollidable = isCollidable;
        this.movementSpeed = movementSpeed;

        this.velocity = new Vector2(0, 0);
    }

    public abstract void render(SpriteBatch batch);
    public abstract void update(float delta);

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
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

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        this.isCollidable = collidable;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}