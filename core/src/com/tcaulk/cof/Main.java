package com.tcaulk.cof;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tcaulk.cof.game.Game;

public class Main extends com.badlogic.gdx.Game {

	public static int SCREEN_WIDTH = 1280;
	public static int SCREEN_HEIGHT = 720;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new Game(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}