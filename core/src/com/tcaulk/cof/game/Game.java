package com.tcaulk.cof.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.tcaulk.cof.GameObject;
import com.tcaulk.cof.Main;
import com.tcaulk.cof.entity.AnimatedEntity;
import com.tcaulk.cof.entity.Player;
import com.tcaulk.cof.entity.Skeleton;
import com.tcaulk.cof.entity.tile.Tile;
import com.tcaulk.cof.input.InputController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Screen {

    private Main main;
    private Player player;
    private InputController inputController;
    private OrthographicCamera camera;
    private List<GameObject> gameObjects;
    private Tile[][] tiles;

    public Game(Main main) {
        this.main = main;

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

        inputController = new InputController();
        gameObjects = new ArrayList<>();

        this.player = new Player(Main.SCREEN_WIDTH / 2 - 48 / 2, Main.SCREEN_HEIGHT / 2 - 60 / 2, inputController);
        gameObjects.add(player);

        for(int i = 0; i < new Random().nextInt(10) + 1; i++) {
            int x = new Random().nextInt(Main.SCREEN_WIDTH - 32) + 16;
            int y = new Random().nextInt(Main.SCREEN_HEIGHT - 32) + 16;
            AnimatedEntity.EntityDirection entityDirection = AnimatedEntity.EntityDirection.Right;
            if(new Random().nextBoolean()) {
                entityDirection = AnimatedEntity.EntityDirection.Left;
            }

            //gameObjects.add(new Skeleton(x, y, entityDirection, player));
        }

        int maxTileHeight = (Main.SCREEN_HEIGHT / 32) + 1;
        int maxTileWidth = (Main.SCREEN_WIDTH / 32) + 1;

        tiles = new Tile[maxTileWidth][maxTileHeight];
        for(int y = 0; y < maxTileHeight; y++) {
            for(int x = 0; x < maxTileWidth; x++) {
                Tile tile = Tile.GRASS;
                int rand = new Random().nextInt(1000) + 1;
                if(rand > 950) {
                    tile = Tile.GRASS_FLOWER;
                } else if(rand == 6) {
                    //tile = Tile.OVERGROWN_GRASS;
                }

                tiles[x][y] = tile;
            }
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        main.batch.setProjectionMatrix(camera.combined);
        main.batch.begin();
        for(int x = 0; x < tiles.length; x++) {
            for(int y = 0; y < tiles[x].length; y++) {
                tiles[x][y].render(main.batch, x * 32, y * 32);
            }
        }

        for(GameObject go : gameObjects) {
            go.render(main.batch);
        }
        main.batch.end();

        update(delta);
    }

    private void update(float delta) {
        for(GameObject go : gameObjects) {
            go.update(delta);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}