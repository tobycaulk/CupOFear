package com.tcaulk.cof.geometry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WireFrameRectangle {

    private Texture wireframe;
    private int boundingBoxWidth;
    private int boundingBoxHeight;
    private int entityWidth;
    private int entityHeight;

    public WireFrameRectangle(int boundingBoxWidth, int boundingBoxHeight, int entityWidth, int entityHeight) {
        this.boundingBoxWidth = boundingBoxWidth;
        this.boundingBoxHeight = boundingBoxHeight;
        this.entityWidth = entityWidth;
        this.entityHeight = entityHeight;

        wireframe = getWireFrame();
    }

    private Texture getWireFrame() {
        Pixmap pixmap = new Pixmap(boundingBoxWidth, boundingBoxHeight, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, boundingBoxWidth, boundingBoxHeight);

        return new Texture(pixmap);
    }

    public void render(SpriteBatch batch, Vector2 entityPosition) {
        int bx = (int) entityPosition.x + ((entityWidth / 2) - (boundingBoxWidth / 2));
        batch.draw(wireframe, bx, entityPosition.y, boundingBoxWidth, boundingBoxHeight);
    }
}