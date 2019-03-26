package com.frontanilla.necromance.zones.shared;

public class SharedConnector {

    private SharedFirebase sharedFirebase;
    private SharedLogic sharedLogic;
    private SharedStuff sharedStuff;

    public SharedConnector() {
        // Instantiate
        sharedFirebase = new SharedFirebase();
        sharedLogic = new SharedLogic();
        sharedStuff = new SharedStuff();
        // Structure
        sharedFirebase.initializeStructure(sharedLogic, sharedStuff);
        // Initialize
        sharedLogic.initState();
        sharedStuff.initStuff();
    }

    public SharedFirebase getSharedFirebase() {
        return sharedFirebase;
    }

    public SharedLogic getSharedLogic() {
        return sharedLogic;
    }

    public SharedStuff getSharedStuff() {
        return sharedStuff;
    }
}
