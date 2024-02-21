package com.example.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Made by Devin Hadley

/**
 * Represents a disc in the Hanoi Towers game.
 * This class encapsulates the properties of a disc, including its size, position, and color,
 * and provides a graphical representation using a {@link Rectangle}.
 */
public class Disc {
    // Constant defining the disc's height
    public static final int DISC_HEIGHT = 50;
    // Diameter of the disc
    private final int diameter;
    // X and Y coordinates of the disc on the canvas
    private int x;
    private int y;
    // Color of the disc
    private final Color color;
    // Graphical representation of the disc
    public Rectangle frontEnd;

    /**
     * Constructs a new Disc object with the specified properties.
     * Initializes the graphical representation of the disc.
     *
     * @param x the X-coordinate of the disc on the canvas.
     * @param y the Y-coordinate of the disc on the canvas.
     * @param c the color of the disc.
     * @param d the diameter of the disc.
     */
    public Disc(int x, int y, Color c, int d) {
        this.x = x;
        this.y = y;
        this.color = c;
        this.diameter = d;
        this.frontEnd = new Rectangle();
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
        this.frontEnd.setHeight(DISC_HEIGHT);
        this.frontEnd.setWidth(d);
        this.frontEnd.setFill(c);
    }

    /**
     * Returns the diameter of the disc.
     *
     * @return the diameter.
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Returns the X-coordinate of the disc.
     *
     * @return the X-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the Y-coordinate of the disc.
     *
     * @return the Y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the color of the disc.
     *
     * @return the color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the position of the disc to the specified coordinates.
     * Updates both the logical and graphical representation of the disc's position.
     *
     * @param x the new X-coordinate of the disc.
     * @param y the new Y-coordinate of the disc.
     */
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
    }
}
