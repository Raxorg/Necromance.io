package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

import static com.frontanilla.necromance.zones.menu.MenuConstants.FADING_DURATION;

public class TransitionHandler {

    // Structure
    private MenuLogic menuLogic;
    private MenuStuff menuStuff;
    // Logic
    private float alpha;
    private boolean started;

    public void initializeStructure(
            MenuLogic menuLogic,
            MenuStuff menuStuff) {
        this.menuLogic = menuLogic;
        this.menuStuff = menuStuff;
    }

    public void initState() {
        alpha = 0;
        started = false;
        menuStuff.getFader().setColor(Color.CLEAR);
    }

    public void fadeOut() {
        started = true;
    }

    public void update(float delta) {
        if (started) {
            alpha += delta / FADING_DURATION;
            menuStuff.getFader().setColor(new Color(1, 1, 1, alpha));
            if (alpha >= 1) {
                started = false;
                menuLogic.getGameAssetsHandler().queueAssetLoading();
            }
        }
    }
}