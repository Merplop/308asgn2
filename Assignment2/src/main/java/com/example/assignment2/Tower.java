package com.example.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents a tower in the Hanoi Towers game.
 * This class encapsulates the properties of a tower, including its dimensions, color, and position,
 * and provides a graphical representation using a {@link Rectangle}.
 */
public class Tower {
    // Constants defining the tower's dimensions and color
    public static final int TOWER_HEIGHT = 300;
    public static final int TOWER_WIDTH = 25;
    public static final Color TOWER_COLOR = Color.BLACK;

    // X and Y coordinates of the tower on the canvas
    private int x;
    private int y;

    // Graphical representation of the tower
    public Rectangle frontEnd;

    /**
     * Constructs a new Tower object at the specified position.
     * Initializes the graphical representation of the tower.
     *
     * @param x the X-coordinate of the tower on the canvas.
     * @param y the Y-coordinate of the tower on the canvas.
     */
    public Tower(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd = new Rectangle();
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
        this.frontEnd.setHeight(TOWER_HEIGHT);
        this.frontEnd.setWidth(TOWER_WIDTH);
        this.frontEnd.setFill(TOWER_COLOR);
    }

    /**
     * Returns the X-coordinate of the tower.
     *
     * @return the X-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the Y-coordinate of the tower.
     *
     * @return the Y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the position of the tower to the specified coordinates.
     * Updates both the logical and graphical representation of the tower's position.
     *
     * @param x the new X-coordinate of the tower.
     * @param y the new Y-coordinate of the tower.
     */
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
    }
}
