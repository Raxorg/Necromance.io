package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.zones.menu.input.MenuInput;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

import static com.frontanilla.necromance.zones.menu.MenuConstants.FADING_DURATION;

public class TransitionHandler {

    // Structure
    private MenuInput menuInput;
    private MenuLogic menuLogic;
    private MenuStuff menuStuff;
    // Logic
    private float alpha;
    private boolean fadingIn, fadingOut;

    public void initializeStructure(
            MenuInput menuInput,
            MenuLogic menuLogic,
            MenuStuff menuStuff) {
        this.menuInput = menuInput;
        this.menuLogic = menuLogic;
        this.menuStuff = menuStuff;
    }

    public void initState() {
        fadeIn();
    }

    public void fadeIn() {
        alpha = 1;
        fadingIn = true;
    }

    public void fadeOut() {
        alpha = 0;
        fadingOut = true;
    }

    public void update(float delta) {
        if (fadingIn) {
            alpha -= delta / FADING_DURATION;
            menuStuff.getFader().setColor(new Color(1, 1, 1, alpha));
            if (alpha <= 0) {
                fadingIn = false;
                menuInput.setEnabled(true);
            }
        } else if (fadingOut) {
            alpha += delta / FADING_DURATION;
            menuStuff.getFader().setColor(new Color(1, 1, 1, alpha));
            if (alpha >= 1) {
                fadingOut = false;
                menuLogic.getGameAssetsHandler().queueAssetLoading();
            }
        }
    }
}