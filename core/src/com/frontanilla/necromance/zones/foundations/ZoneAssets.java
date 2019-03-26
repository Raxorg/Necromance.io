package com.frontanilla.necromance.zones.foundations;

import com.badlogic.gdx.assets.AssetManager;

public abstract class ZoneAssets {

    protected AssetManager assetManager;

    public abstract void queueAssetLoading();

    public abstract void instantiateAssets();

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
