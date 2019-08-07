package com.tcaulk.cof.entity.tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tcaulk.cof.TextureStore;

public class TileOvergrownGrass extends Tile {
    public TileOvergrownGrass() {
        super(new TextureRegion(TextureStore.TILES, 112, 64, 16, 16), 32, 32, false);
    }
}
