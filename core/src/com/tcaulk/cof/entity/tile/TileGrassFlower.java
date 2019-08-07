package com.tcaulk.cof.entity.tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tcaulk.cof.TextureStore;

public class TileGrassFlower extends Tile {
    public TileGrassFlower() {
        super(new TextureRegion(TextureStore.TILES, 0, 112, 16, 16), 32, 32, false);
    }
}
