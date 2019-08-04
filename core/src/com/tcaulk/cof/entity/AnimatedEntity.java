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
    EntityDirection entityDirection;

    AnimatedEntity(int x, int y, int width, int height, boolean isCollidable, float movementSpeed, float velocitySmooth, int initialAnimationIndex, EntityDirection startingEntityDirection) {
        super(x, y, width, height, isCollidable, movementSpeed, velocitySmooth);

        this.animationProvider = new AnimationProvider(getAnimations(), initialAnimationIndex);
        this.entityDirection = startingEntityDirection;
    }

    protected abstract List<Animation> getAnimations();

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(animationProvider.getCurrentFrameTexture(entityDirection.shouldFlip), position.x, position.y, width, height);
    }

    void setAnimationIndex(int animationIndex) {
        animationProvider.setCurrentAnimationIndex(animationIndex);
    }
}