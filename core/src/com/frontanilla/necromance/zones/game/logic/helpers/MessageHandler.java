package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.utils.helpers.Random;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

import java.util.LinkedList;
import java.util.Queue;

import static com.frontanilla.necromance.zones.game.GameConstants.MESSAGE_DURATION;

public class MessageHandler {

    // Structure
    private GameLogic gameLogic;
    private GameStuff gameStuff;
    // Logic
    private Queue<String> messageQueue;
    private float time;
    private boolean showingMessage;

    public void initializeStructure(
            GameLogic gameLogic,
            GameStuff gameStuff
    ) {
        this.gameLogic = gameLogic;
        this.gameStuff = gameStuff;
    }

    public void initState() {
        messageQueue = new LinkedList<>();
        time = 0;
        showingMessage = false;
    }

    public void update(float delta) {
        if (showingMessage) {
            time += delta;
            if (time >= MESSAGE_DURATION) {
                gameStuff.getMessageBox().setBoxColor(new Color(0f, 0f, 0f, 0f));
                gameStuff.getMessageBox().setFontColor(new Color(0f, 0f, 0f, 0f));
                time = 0;
                showingMessage = false;
            }
        } else if (!messageQueue.isEmpty()) {
            showNextMessage();
        }
    }

    public void addMessage(String message) {
        messageQueue.add(message);
    }

    private void showNextMessage() {
        gameStuff.getMessageBox().setBoxColor(Random.color(new Color(0f, 0f, 0f, 0f)));
        gameStuff.getMessageBox().setFontColor(Color.WHITE);
        gameStuff.getMessageBox().setText(messageQueue.remove());
        showingMessage = true;
    }
}