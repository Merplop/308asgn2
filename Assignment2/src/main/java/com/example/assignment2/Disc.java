package com.example.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Disc {
    public static final int DISC_HEIGHT = 50;
    private final int diameter;
    private int x;
    private int y;
    private final Color color;
    public Rectangle frontEnd;

    /**
     *  Class constructor
     * @param x X-position of disc on canvas
     * @param y Y-position of disc on canvas
     * @param c Color to draw disc
     * @param d Diameter of disc
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

    public int getDiameter() {
        return diameter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
    }
}
