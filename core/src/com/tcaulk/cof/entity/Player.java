package com.tcaulk.cof.entity;

import com.badlogic.gdx.math.Vector2;
import com.tcaulk.cof.TextureStore;
import com.tcaulk.cof.animation.Animation;
import com.tcaulk.cof.input.InputController;

import java.util.Arrays;
import java.util.List;

public class Player extends AnimatedEntity {

    private static final float MOVEMENT_SPEED = 150f;
    private static final float VELOCITY_SMOOTH = 0.52f;

    public static enum PlayerAnimation {
        IDLE(0),
        RUN(1);

        private int animationIndex;
        PlayerAnimation(int animationIndex) {
            this.animationIndex = animationIndex;
        }

        public int getAnimationIndex() {
            return animationIndex;
        }
    }

    private InputController inputController;

    public Player(int x, int y, InputController inputController) {
        super(x, y, 48, 84, true, MOVEMENT_SPEED, VELOCITY_SMOOTH, 38, 54, PlayerAnimation.IDLE.getAnimationIndex(), EntityDirection.Right);

        this.inputController = inputController;
    }

    @Override
    protected List<Animation> getAnimations() {
        return Arrays.asList(
                new Animation(TextureStore.SPRITESHEET, Animation.getFrameRange(128, 100, 16, 28, 4)),
                new Animation(TextureStore.SPRITESHEET, Animation.getFrameRange(192, 100, 16, 28, 4))
        );
    }

    @Override
    public void update(float delta) {
        Vector2 acceleration = new Vector2(0, 0);
        boolean moving = false;
        EntityDirection nextEntityDirection = entityDirection;

        if(inputController.isDownPressed()) {
            acceleration.y += -movementSpeed * delta;
            moving = true;
        } else if(inputController.isUpPressed()) {
            acceleration.y += +movementSpeed * delta;
            moving = true;
        }

        if(inputController.isLeftPressed()) {
            acceleration.x += -movementSpeed * delta;
            moving = true;
            nextEntityDirection = EntityDirection.Left;
        } else if(inputController.isRightPressed()) {
            acceleration.x += movementSpeed * delta;
            moving = true;
            nextEntityDirection = EntityDirection.Right;
        }

        velocity.add(acceleration);
        position.add(velocity);

        velocity.x *= velocitySmooth;
        velocity.y *= velocitySmooth;

        if(moving) {
            setAnimationIndex(PlayerAnimation.RUN.getAnimationIndex());
        } else {
            setAnimationIndex(PlayerAnimation.IDLE.getAnimationIndex());
        }

        entityDirection = nextEntityDirection;
    }
}