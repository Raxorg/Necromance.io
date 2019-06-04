package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.badlogic.gdx.math.MathUtils;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class CharacterMovementHandler {

    // Structure
    private MenuStuff menuStuff;
    // Logic
    private boolean moving;
    private float time, movingTime, flippingTime, startingWidth, modifier;
    private boolean facingLeft, movingLeft, movingRight;
    private boolean flippingLeft, flippingRight, flipped;

    public void initializeStructure(MenuStuff menuStuff) {
        this.menuStuff = menuStuff;
    }

    public void initState() {
        moving = true;
        time = 2f;
        startingWidth = menuStuff.getMenuCharacter().getBounds().width;
        modifier = 1f;
        facingLeft = false;
        movingLeft = false;
        movingRight = false;
        flipped = false;
    }

    public void update(float delta) {
        handleFlipping(delta);
        handleMoving(delta);
        time -= delta;
        if (time <= 0f && moving) {
            startMovingCharacter();
            time = 1f + MathUtils.random(3f);
        }
    }

    private void handleFlipping(float delta) {
        if (flippingRight) {
            if (flippingTime >= 0.25f) {
                menuStuff.getMenuCharacter().getBounds().width = modifier * (startingWidth / 100f) * (flippingTime - 0.25f) * 400f;
            } else if (flippingTime >= 0f) {
                menuStuff.getMenuCharacter().getBounds().width = modifier * (startingWidth / 100f) * (0.25f - flippingTime) * 400f;
            } else {
                flippingRight = false;
            }
        }
        if (flippingLeft) {
            if (flippingTime >= 0.25f) {
                menuStuff.getMenuCharacter().getBounds().width = modifier * (startingWidth / 100f) * (flippingTime - 0.25f) * 400f;
            } else if (flippingTime >= 0f) {
                menuStuff.getMenuCharacter().getBounds().width = modifier * (startingWidth / 100f) * (0.25f - flippingTime) * 400f;
            } else {
                flippingLeft = false;
            }
        }
        flippingTime -= delta;
        if (flippingTime <= 0.25f && !flipped) {
            if (flippingLeft && !facingLeft) {
                modifier *= -1f;
                menuStuff.getMenuCharacter().getBounds().width *= modifier;
                flipped = true;
                facingLeft = true;
            }
            if (flippingRight && facingLeft) {
                modifier *= -1f;
                menuStuff.getMenuCharacter().getBounds().width *= modifier;
                flipped = true;
                facingLeft = false;
            }
        }
    }

    private void handleMoving(float delta) {
        if (movingTime > 0) {
            movingTime -= delta;
            if (movingLeft) {
                menuStuff.getMenuCharacter().getBounds().x -= delta * 100f;
            }
            if (movingRight) {
                menuStuff.getMenuCharacter().getBounds().x += delta * 100f;
            }
        } else {
            movingRight = false;
            movingLeft = false;
        }
    }

    private void startMovingCharacter() {
        if (MathUtils.randomBoolean()) {
            if (!facingLeft) {
                startFlippingCharacter(true);
            }
            movingLeft = true;
        } else {
            if (facingLeft) {
                startFlippingCharacter(false);
            }
            movingRight = true;
        }
        movingTime = 1f;
    }

    private void startFlippingCharacter(boolean left) {
        if (left) {
            flippingLeft = true;
        } else {
            flippingRight = true;
        }
        flippingTime = 0.5f;
        flipped = false;
    }
}