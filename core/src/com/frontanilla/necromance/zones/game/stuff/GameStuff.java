package com.frontanilla.necromance.zones.game.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.shared.SharedStuff;

public class GameStuff extends ZoneStuff {

    private DelayedRemovalArray<Human> players;

    public GameStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    @Override
    public void initStuff() {
        players = new DelayedRemovalArray<>();
    }

    public DelayedRemovalArray<Human> getHumanPlayers() {
        return players;
    }
}
