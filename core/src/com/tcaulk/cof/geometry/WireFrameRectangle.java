package com.tcaulk.cof.geometry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WireFrameRectangle {

    private Texture wireframe;

    public WireFrameRectangle(int width, int height) {
        wireframe = getWireFrame(width, height);
    }

    private Texture getWireFrame(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, width, height);

        return new Texture(pixmap);
    }

    public void render(SpriteBatch batch, int x, int y, int width, int height) {
        batch.draw(wireframe, x, y, width, height);
    }
}