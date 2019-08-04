package com.tcaulk.cof.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

public class AnimationProvider {

    private List<Animation> animations;
    private int currentAnimationIndex;

    public AnimationProvider(List<Animation> animations, int currentAnimationIndex) {
        this.animations = animations;
        this.currentAnimationIndex = currentAnimationIndex;
    }

    public TextureRegion getCurrentFrameTexture(boolean flipTextureX) {
        Animation currentAnimation = animations.get(currentAnimationIndex);
        if(currentAnimation == null) {
            return null;
        }

        TextureRegion animationTexture = currentAnimation.getCurrentFrame();
        if(animationTexture == null) {
            return null;
        }

        animationTexture.flip(flipTextureX, false);

        return animationTexture;
    }

    public void setCurrentAnimationIndex(int animationIndex) {
        this.currentAnimationIndex = animationIndex;
    }
}