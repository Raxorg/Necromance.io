package com.frontanilla.necromance.zones.foundations;

import com.frontanilla.necromance.zones.shared.SharedLogic;

public abstract class ZoneLogic {

    protected SharedLogic sharedLogic;

    public ZoneLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public abstract void initState();

    public abstract void update(float delta);

    public SharedLogic getSharedLogic() {
        return sharedLogic;
    }
}