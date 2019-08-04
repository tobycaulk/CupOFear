package com.tcaulk.cof.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.tcaulk.cof.Main;
import com.tcaulk.cof.entity.AnimatedEntity;
import com.tcaulk.cof.entity.Player;
import com.tcaulk.cof.entity.Skeleton;
import com.tcaulk.cof.input.InputController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Screen {

    private Main main;
    private Player player;
    private InputController inputController;
    private OrthographicCamera camera;
    private List<Skeleton> skeletons;

    public Game(Main main) {
        this.main = main;

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

        inputController = new InputController();

        this.player = new Player(Main.SCREEN_WIDTH / 2 - 48 / 2, Main.SCREEN_HEIGHT / 2 - 60 / 2, inputController);
        this.skeletons = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(10) + 1; i++) {
            int x = new Random().nextInt(Main.SCREEN_WIDTH - 32) + 16;
            int y = new Random().nextInt(Main.SCREEN_HEIGHT - 32) + 16;
            AnimatedEntity.EntityDirection entityDirection = AnimatedEntity.EntityDirection.Right;
            if(new Random().nextBoolean()) {
                entityDirection = AnimatedEntity.EntityDirection.Left;
            }

            skeletons.add(new Skeleton(x, y, entityDirection, player));
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
        player.render(main.batch);
        for(Skeleton s : skeletons) {
            s.render(main.batch);
        }
        main.batch.end();

        update(delta);
    }

    private void update(float delta) {
        player.update(delta);
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