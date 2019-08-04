package com.tcaulk.cof.entity;

import com.badlogic.gdx.math.Vector2;

public abstract class Monster extends AnimatedEntity {

    private Player player;

    Monster(int x, int y, int width, int height, float movementSpeed, float velocitySmooth, int initialAnimationIndex, EntityDirection startingEntityDirection, Player player) {
        super(x, y, width, height, true, movementSpeed, velocitySmooth, initialAnimationIndex, startingEntityDirection);

        this.player = player;
    }

    @Override
    public void update(float delta) {
        Vector2 acceleration = new Vector2(0, 0);
        boolean moving = false;
        EntityDirection nextEntityDirection = entityDirection;

        if(player.getPosition().y > position.y) {
            acceleration.y += movementSpeed * delta;
            moving = true;
        } else {
            acceleration.y += -movementSpeed * delta;
            moving = true;
        }

        if(player.getPosition().x > position.x) {
            acceleration.x += movementSpeed * delta;
            moving = true;
        } else {
            acceleration.x += -movementSpeed * delta;
            moving = true;
        }

        velocity.add(acceleration);
        position.add(velocity);

        velocity.x *= velocitySmooth;
        velocity.y *= velocitySmooth;

        entityDirection = nextEntityDirection;
    }
}