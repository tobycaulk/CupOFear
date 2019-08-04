package com.tcaulk.cof.util;

import com.badlogic.gdx.math.Vector2;

public class MathUtil {

    public static double distance(Vector2 origin, Vector2 end) {
        return Math.sqrt(Math.pow((end.x - origin.x), 2) + Math.pow((end.x - origin.y), 2));
    }
}