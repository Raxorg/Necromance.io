package com.frontanilla.necromance.zones.foundations;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.math.Vector3;

public abstract class ZoneInput extends InputMultiplexer {

    protected boolean enabled;
    protected Vector3 unprojected;

    public abstract void initConfig();

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
