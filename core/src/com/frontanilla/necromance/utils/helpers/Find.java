package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.core.NecromanceClient;
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
}
