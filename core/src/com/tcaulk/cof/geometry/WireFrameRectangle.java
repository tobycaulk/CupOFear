package com.tcaulk.cof.geometry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tcaulk.cof.GameObject;

public class WireFrameRectangle {

    private Texture wireframe;
    private int width;
    private int height;

    public WireFrameRectangle(int width, int height) {
        this.width = width;
        this.height = height;

        wireframe = getWireFrame();
    }

    private Texture getWireFrame() {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, width, height);

        return new Texture(pixmap);
    }

    public void render(SpriteBatch batch, int ex, int ey) {
        //batch.draw(wireframe, x, y, boundingBoxWidth, );
    }
}