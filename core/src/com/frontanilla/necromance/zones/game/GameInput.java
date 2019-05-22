package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneInput;
import com.frontanilla.necromance.zones.game.logic.GameLogic;

public class GameInput extends ZoneInput {

    // Structure
    private GameLogic gameLogic;
    private GameScreen gameScreen;
    private GameNetworked gameNetworked;

    public void initializeStructure(GameLogic gameLogic, GameScreen gameScreen, GameNetworked gameNetworked) {
        this.gameLogic = gameLogic;
        this.gameScreen = gameScreen;
        this.gameNetworked = gameNetworked;
    }

    @Override
    public void initConfig() {
        unprojected = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!enabled || pointer != 0) {
            return false;
        }
        unprojected.set(gameScreen.getStaticCamera().unproject(new Vector3(screenX, screenY, 0)));
        // Human Players
        DelayedRemovalArray<Human> humanPlayers = gameNetworked.getHumanPlayers();
        for (int i = 0; i < humanPlayers.size; i++) {
            if (humanPlayers.get(i).contains(unprojected.x, unprojected.y)) {
                gameLogic.getProcessedInputHandler().touchDownOnHumanPlayer(humanPlayers.get(i));
                return false;
            }
        }
        // Empty Space
        gameLogic.getProcessedInputHandler().touchDownOnEmptySpace((int) unprojected.x, (int) unprojected.y);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (!enabled) {
            return false;
        }
        if (keycode == Input.Keys.SPACE) {
            gameLogic.getProcessedInputHandler().spaceKeyUp();
        }
        return true;
    }
}