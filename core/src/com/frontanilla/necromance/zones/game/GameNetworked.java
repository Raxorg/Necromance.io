package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneNetworked;

public class GameNetworked extends ZoneNetworked {

    private DelayedRemovalArray<Human> players;

    public DelayedRemovalArray<Human> getHumanPlayers() {
        return players;
    }

    @Override
    public void initNetworked() {
        players = new DelayedRemovalArray<>();
    }
}
