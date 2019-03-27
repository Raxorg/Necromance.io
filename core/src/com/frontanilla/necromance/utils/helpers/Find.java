package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.database.representation.Human;

public class Find {

    public static Human humanWithPhoneID(DelayedRemovalArray<Human> humans) {
        return humanWithPhoneID(NecromanceClient.instance.getPhoneID(), humans);
    }

    public static Human humanWithPhoneID(String phoneID, DelayedRemovalArray<Human> humans) {
        for (int i = 0; i < humans.size; i++) {
            if (humans.get(i).getDatabasePlayer().getPlayerID().equals(phoneID)) {
                return humans.get(i);
            }
        }
        return null;
    }

    public static DBPlayer databasePlayerWithPhoneID(DelayedRemovalArray<DBPlayer> databasePlayers) {
        return databasePlayerWithPhoneID(NecromanceClient.instance.getPhoneID(), databasePlayers);
    }

    public static DBPlayer databasePlayerWithPhoneID(String phoneID, DelayedRemovalArray<DBPlayer> databasePlayers) {
        for (int i = 0; i < databasePlayers.size; i++) {
            if (databasePlayers.get(i).getPlayerID().equals(phoneID)) {
                return databasePlayers.get(i);
            }
        }
        return null;
    }
}
