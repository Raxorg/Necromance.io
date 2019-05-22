package com.frontanilla.necromance.database.representation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.database.subscribers.DBPlayerSubscriber;
import com.frontanilla.necromance.utils.helpers.Transform;
import com.frontanilla.necromance.zones.game.stuff.NameBox;

import static com.frontanilla.necromance.zones.game.GameConstants.HUMAN_SIZE;

public class Human extends DBPlayerSubscriber {

    private DBPlayerDocument databasePlayer;
    // Additional - Components
    private NameBox nameBox;
    private TextureRegion textureRegion;
    // Additional - Rendering
    private Color color;
    private boolean useOriginalColor;

    public Human(DBPlayerDocument playerDocument, TextureRegion nameBoxNinePatch, BitmapFont nameBoxBitmapFont) {
        this.databasePlayer = playerDocument;
        playerDocument.setDBPlayerSubscriber(this);
        useOriginalColor = true;
        // Name Box
        nameBox = new NameBox(nameBoxNinePatch, nameBoxBitmapFont);
        onUpdate(playerDocument);
    }

    public void render(SpriteBatch spriteBatch) {
        nameBox.render(spriteBatch);
        if (useOriginalColor) {
            spriteBatch.setColor(color);
        } else {
            spriteBatch.setColor(color.cpy().lerp(Color.BLACK, 0.5f));
        }
        spriteBatch.draw(textureRegion, databasePlayer.getX(), databasePlayer.getY(), HUMAN_SIZE, HUMAN_SIZE);
    }

    public boolean contains(float x, float y) {
        return new Rectangle(databasePlayer.getX(), databasePlayer.getY(), HUMAN_SIZE, HUMAN_SIZE).contains(x, y);
    }

    // Getters & Setters
    public DBPlayerDocument getDatabasePlayer() {
        return databasePlayer;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public void setUseOriginalColor(boolean useOriginalColor) {
        this.useOriginalColor = useOriginalColor;
    }

    @Override
    public void onUpdate(DBPlayerDocument databasePlayer) {
        // Name Box
        nameBox.setText(databasePlayer.getName());
        float nameBoxX = databasePlayer.getX() + HUMAN_SIZE / 2f - nameBox.getWidth() / 2f;
        float nameBoxY = databasePlayer.getY() + HUMAN_SIZE + nameBox.getTextHeight() / 3f;
        nameBox.setPosition(nameBoxX, nameBoxY);
        nameBox.setBoxColor(Transform.stringToColor(databasePlayer.getColor()));
        // Character
        color = Transform.stringToColor(databasePlayer.getColor());
    }
}
