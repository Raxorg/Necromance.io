package com.frontanilla.necromance.zones.game;

import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;
import com.frontanilla.necromance.zones.shared.SharedConnector;

public class GameConnector extends ZoneConnector {

    public GameConnector(SharedConnector sharedConnector, GameAssets gameAssets) {
        super(sharedConnector);
        assets = gameAssets;
        firebase = new GameFirebase(sharedConnector.getSharedFirebase());
        initializer = new GameInitializer(this);
        input = new GameInput();
        logic = new GameLogic(sharedConnector.getSharedLogic());
        networked = new GameNetworked();
        renderer = new GameRenderer();
        screen = new GameScreen(this);
        stuff = new GameStuff(sharedConnector.getSharedStuff());
    }
}
