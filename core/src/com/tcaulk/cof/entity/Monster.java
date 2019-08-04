package com.tcaulk.cof.entity;

import com.tcaulk.cof.animation.Animation;

import java.util.List;

public class Monster extends AnimatedEntity {

    private Player player;

    public Monster(int x, int y, int width, int height, float movementSpeed, List<Animation> animations, int initialAnimationIndex, EntityDirection startingEntityDirection, Player player) {
        super(x, y, width, height, true, movementSpeed, animations, initialAnimationIndex, startingEntityDirection);
    }

    @Override
    public void update(float delta) {

    }
}