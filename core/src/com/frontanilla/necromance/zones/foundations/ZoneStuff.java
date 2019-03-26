package com.frontanilla.necromance.zones.foundations;


import com.frontanilla.necromance.zones.shared.SharedStuff;

public abstract class ZoneStuff {

    protected SharedStuff sharedStuff;

    public ZoneStuff(SharedStuff sharedStuff) {
        this.sharedStuff = sharedStuff;
    }

    public abstract void initStuff();

    public SharedStuff getSharedStuff() {
        return sharedStuff;
    }
}
