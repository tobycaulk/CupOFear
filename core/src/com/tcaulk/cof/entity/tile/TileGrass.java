package com.tcaulk.cof.entity.tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tcaulk.cof.TextureStore;

public class TileGrass extends Tile {
    public TileGrass() {
        super(new TextureRegion(TextureStore.TILES, 16, 112, 16, 16), 32, 32, false);
    }
}