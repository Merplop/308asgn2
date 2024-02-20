package com.example.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Tower {
    public static final int TOWER_HEIGHT = 300;
    public static final int TOWER_WIDTH = 25;
    public static final Color TOWER_COLOR = Color.BLACK;
    private int x;
    private int y;
    public Rectangle frontEnd;

    /**
     *  Class constructor
     * @param x X-position of tower on canvas
     * @param y Y-position of tower on canvas
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
    }
}
