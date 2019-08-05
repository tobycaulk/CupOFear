package com.tcaulk.cof.entity;

import com.badlogic.gdx.math.Vector2;
import com.tcaulk.cof.GameObject;

public abstract class Entity extends GameObject {
    public Entity(int x, int y, int width, int height, boolean isCollidable, float movementSpeed, float velocitySmooth, int boundingBoxWidth, int boundingBoxHeight) {
        super(new Vector2(x, y), width, height, isCollidable, movementSpeed, velocitySmooth, boundingBoxWidth, boundingBoxHeight);
    }
}