package com.frontanilla.necromance.database.representation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.utils.helpers.TextUtils;
import com.frontanilla.necromance.utils.helpers.Transform;

import static com.frontanilla.necromance.zones.game.GameConstants.HUMAN_SIZE;

public class Human {

    // Database Object that This Class Represents
    private DBPlayer databasePlayer;
    // Additional - Components
    private BitmapFont font;
    private TextureRegion textureRegion;
    // Additional - Rendering
    private float textWidth, textHeight;
    private Color originalColor, currentColor;

    public Human(DBPlayer databasePlayer) {
        this.databasePlayer = databasePlayer;
        originalColor = Transform.stringToColor(databasePlayer.getColor());
        currentColor = Transform.stringToColor(databasePlayer.getColor());
    }

    public void render(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        float fontX = databasePlayer.getX() + HUMAN_SIZE / 2f - textWidth / 2f;
        float fontY = databasePlayer.getY() + HUMAN_SIZE + textHeight + textHeight / 3f;
        font.draw(spriteBatch, databasePlayer.getName(), fontX, fontY);
        spriteBatch.setColor(currentColor);
        //spriteBatch.draw(textureRegion, databasePlayer.getX(), databasePlayer.getY(), HUMAN_SIZE, HUMAN_SIZE);
        spriteBatch.draw(textureRegion, databasePlayer.getX(), databasePlayer.getY(), HUMAN_SIZE, HUMAN_SIZE);
    }

    public boolean contains(float x, float y) {
        return new Rectangle(databasePlayer.getX(), databasePlayer.getY(), HUMAN_SIZE, HUMAN_SIZE).contains(x, y);
    }

    // Getters & Setters
    public DBPlayer getDatabasePlayer() {
        return databasePlayer;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
        textWidth = TextUtils.getTextWidth(databasePlayer.getName(), font);
        textHeight = TextUtils.getTextHeight(databasePlayer.getName(), font);
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public Color getOriginalColor() {
        return originalColor;
    }
}
