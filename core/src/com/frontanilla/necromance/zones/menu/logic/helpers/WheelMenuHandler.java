package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

import static com.frontanilla.necromance.zones.menu.MenuConstants.WHEEL_FLING_VELOCITY_MODIFIER;

public class WheelMenuHandler {

    // Structure
    private MenuStuff menuStuff;
    // Logic
    private boolean touchOnWheel;
    // Movement
    private float wheelSpeed;
    private float wheelFriction;

    public void initializeStructure(MenuStuff menuStuff) {
        this.menuStuff = menuStuff;
    }

    public void initState() {
        wheelSpeed = 0;
        wheelFriction = 1;
    }

    public void update(float delta) {
        menuStuff.getWheelMenu().setRotation(menuStuff.getWheelMenu().getRotation() + wheelSpeed * delta);
        if (wheelSpeed > 0) {
            wheelSpeed = wheelSpeed - wheelFriction * delta;
            if (wheelSpeed < 0) {
                wheelSpeed = 0;
            }
        } else {
            wheelSpeed = wheelSpeed + wheelFriction * delta;
            if (wheelSpeed > 0) {
                wheelSpeed = 0;
            }
        }
    }

    public void touchDragged(float x, float y) {
        touchOnWheel = menuStuff.getWheelMenu().getBounds().contains(x, y);
    }

    public void fling(float velocityY) {
        if (touchOnWheel) {
            wheelSpeed = velocityY * WHEEL_FLING_VELOCITY_MODIFIER;
        }
    }
}