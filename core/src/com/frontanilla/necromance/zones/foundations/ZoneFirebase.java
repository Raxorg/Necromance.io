package com.frontanilla.necromance.zones.foundations;

import com.frontanilla.necromance.zones.shared.SharedFirebase;

public abstract class ZoneFirebase {

    protected SharedFirebase sharedFirebase;

    public ZoneFirebase(SharedFirebase sharedFirebase) {
        this.sharedFirebase = sharedFirebase;
    }

    public SharedFirebase getSharedFirebase() {
        return sharedFirebase;
    }
}
