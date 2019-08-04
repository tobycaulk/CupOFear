package com.tcaulk.cof.geometry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WireFrameRectangle {

    public static void render(SpriteBatch batch, int x, int y, int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(new Color(0, 1, 1, 0.5f));
        pixmap.drawLine(x, y, x + width, y);
        pixmap.drawLine(x, y, x, y + height);
        pixmap.drawLine(x, y + height, x + width, y + height);
        pixmap.drawLine(x + width, y + height, x + width, y);
        batch.draw(new Texture(pixmap), x, y, width, height);
    }
}