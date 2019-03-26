package com.frontanilla.necromance.zones.shared;

public class SharedConnector {

    private SharedFirebase sharedFirebase;
    private SharedStuff sharedStuff;

    public SharedConnector() {
        // Instantiate
        sharedFirebase = new SharedFirebase();
        sharedStuff = new SharedStuff();
        // Structure
        sharedFirebase.initializeStructure(sharedStuff);
        // Initialize
        sharedStuff.initStuff();
    }

    public SharedFirebase getSharedFirebase() {
        return sharedFirebase;
    }

    public SharedStuff getSharedStuff() {
        return sharedStuff;
    }
}
