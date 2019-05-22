package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.utils.helpers.ColorUtils;
import com.frontanilla.necromance.utils.helpers.Random;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;
import com.frontanilla.necromance.zones.game.stuff.NameBox;

import java.util.LinkedList;
import java.util.Queue;

import static com.frontanilla.necromance.zones.game.GameConstants.MESSAGE_DURATION;
import static com.frontanilla.necromance.zones.game.GameConstants.MESSAGE_FADING_DURATION;

public class MessageHandler {

    // Structure
    private GameStuff gameStuff;
    // Logic
    private Queue<String> messageQueue;
    private float time, alpha;
    private boolean showingMessage, fadingIn, fadingOut;

    public void initializeStructure(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    public void initState() {
        messageQueue = new LinkedList<>();
        time = 0;
        alpha = 0;
        gameStuff.getMessageBox().setBoxColor(Color.CLEAR);
        gameStuff.getMessageBox().setFontColor(Color.CLEAR);
        showingMessage = false;
        fadingIn = false;
        fadingOut = false;
    }

    public void update(float delta) {
        if (showingMessage) {
            time += delta;
            handleFading(delta);
            if (time >= MESSAGE_DURATION) {
                time = 0;
                showingMessage = false;
            }
        } else if (!messageQueue.isEmpty()) {
            showNextMessage();
        }
    }

    private void handleFading(float delta) {
        if (fadingIn) {
            alpha += delta;
            if (alpha >= 1f) {
                alpha = 1f;
                fadingIn = false;
            }
        }
        if (time >= MESSAGE_DURATION - MESSAGE_FADING_DURATION) {
            fadingOut = true;
        }
        if (fadingOut) {
            alpha -= delta;
            if (alpha <= 0f) {
                alpha = 0f;
                fadingOut = false;
            }
        }
        gameStuff.getMessageBox().setBoxColor(ColorUtils.colorWithAlpha(gameStuff.getMessageBox().getBoxColor(), alpha));
        gameStuff.getMessageBox().setFontColor(ColorUtils.colorWithAlpha(gameStuff.getMessageBox().getFontColor(), alpha));
    }

    public void addMessage(String message) {
        messageQueue.add(message);
    }

    private void showNextMessage() {
        NameBox messageBox = gameStuff.getMessageBox();
        messageBox.setBoxColor(ColorUtils.colorWithAlpha(Random.color(messageBox.getBoxColor()), 0f));
        messageBox.setFontColor(ColorUtils.colorWithAlpha(Color.WHITE, 0f));
        messageBox.setText(messageQueue.remove());
        showingMessage = true;
        fadingIn = true;
    }
}