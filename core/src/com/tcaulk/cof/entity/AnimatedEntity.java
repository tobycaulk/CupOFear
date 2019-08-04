package com.tcaulk.cof.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tcaulk.cof.animation.Animation;
import com.tcaulk.cof.animation.AnimationProvider;

import java.util.List;

public abstract class AnimatedEntity extends Entity {

    public static enum EntityDirection {
        Left(true),
        Right(false);

        private boolean shouldFlip;

        EntityDirection(boolean shouldFlip) {
            this.shouldFlip = shouldFlip;
        }

        public boolean shouldFip() {
            return shouldFlip;
        }
    }

    private AnimationProvider animationProvider;
    protected EntityDirection entityDirection;

    public AnimatedEntity(int x, int y, int width, int height, boolean isCollidable, float movementSpeed, List<Animation> animations, int initialAnimationIndex, EntityDirection startingEntityDirection) {
        super(x, y, width, height, isCollidable, movementSpeed);

        this.animationProvider = new AnimationProvider(animations, initialAnimationIndex);
        this.entityDirection = startingEntityDirection;
    }

    @Override
    public void render(SpriteBatch batch) {
        System.out.println(entityDirection);
        batch.draw(animationProvider.getCurrentFrameTexture(entityDirection.shouldFlip), position.x, position.y, width, height);
    }

    public void setAnimationIndex(int animationIndex) {
        animationProvider.setCurrentAnimationIndex(animationIndex);
    }
}