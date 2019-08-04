package com.tcaulk.cof.entity;

import com.tcaulk.cof.TextureStore;
import com.tcaulk.cof.animation.Animation;

import java.util.Arrays;
import java.util.List;

public class Skeleton extends Monster {

    private static final float MOVEMENT_SPEED = 100f;
    private static final float VELOCITY_SMOOTH = 0.52f;

    public static enum SkeletonAnimation {
        IDLE(0),
        RUN(1);

        private int animationIndex;
        SkeletonAnimation(int animationIndex) {
            this.animationIndex = animationIndex;

        }

        public int getAnimationIndex() {
            return animationIndex;
        }
    }

    public Skeleton(int x, int y, EntityDirection startingEntityDirection, Player player) {
        super(x, y, 48, 48, MOVEMENT_SPEED, Arrays.asList(
                new Animation(TextureStore.SPRITESHEET, Animation.getFrameRange(368, 80, 16, 16, 4)),
                new Animation(TextureStore.SPRITESHEET, Animation.getFrameRange(432, 80, 16, 16, 4))
        ), SkeletonAnimation.IDLE.getAnimationIndex(), startingEntityDirection, player);
    }
}
