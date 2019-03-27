package com.frontanilla.necromance.database.clone;

public class DBVersion {

    private String version;

    public String getVersion() {
        return version;
    }

    public void updateVersion(String version) {
        this.version = version;
    }
}
