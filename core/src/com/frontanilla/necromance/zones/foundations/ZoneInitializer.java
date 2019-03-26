package com.frontanilla.necromance.zones.foundations;

public abstract class ZoneInitializer {

    protected ZoneConnector connector;

    public ZoneInitializer(ZoneConnector connector) {
        this.connector = connector;
    }

    // All Helpers are Created Here, and then Distributed Amongst All Other Major Classes
    public abstract void initialize();
}
