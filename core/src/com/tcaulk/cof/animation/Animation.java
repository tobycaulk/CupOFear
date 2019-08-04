package com.tcaulk.cof.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
    private static final int MAX_FRAME_TIME = 5;

    private Texture spritesheet;
    private Frame[] frames;
    private int currentFrameIndex = 0;
    private int currentFrameTime = 0;

    public Animation(Texture spritesheet, Frame[] frames) {
        this.spritesheet = spritesheet;
        this.frames = frames;
    }

    public TextureRegion getCurrentFrame() {
        if(currentFrameTime == MAX_FRAME_TIME) {
            currentFrameTime = 0;
            currentFrameIndex++;
        }

        if(currentFrameIndex == frames.length) {
            currentFrameIndex = 0;
        }

        Frame currentFrame = frames[currentFrameIndex];

        currentFrameTime++;

        return new TextureRegion(spritesheet, currentFrame.x, currentFrame.y, currentFrame.width, currentFrame.height);
    }

    public static Frame[] getFrameRange(int startX, int y, int frameWidth, int frameHeight, int frameCount) {
        Frame[] frames = new Frame[frameCount];

        for(int i = 0; i < frameCount; i++) {
            frames[i] = new Frame((i * frameWidth) + startX, y, frameWidth, frameHeight);
        }

        return frames;
    }

    public static class Frame {
        private int x;
        private int y;
        private int width;
        private int height;

        public Frame(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
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
    }
}