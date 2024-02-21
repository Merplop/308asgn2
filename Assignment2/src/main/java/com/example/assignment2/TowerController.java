package com.example.assignment2;

import javafx.scene.paint.Color;

/**
 * This class is responsible for managing the towers and discs in the Hanoi Towers game.
 * It initializes the towers and discs, and provides methods for manipulating the discs on the towers.
 */
public class TowerController {
    // Array of towers in the game
    public Tower[] towers = new Tower[3];
    // Matrix representing the discs on each tower
    public Disc[][] discsOnTowers = new Disc[3][3];
    // Array tracking the number of discs on each tower
    public int[] numDiscs = new int[3];

    /**
     * Constructs a new TowerController object. Initializes the towers and places discs on the first tower.
     */
    public TowerController() {
        // Initialize towers at specific positions
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(100 + (200 * i), 300);
        }
        // Initialize discs with different colors and sizes on the first tower
        discsOnTowers[0][0] = new Disc(100, 300, Color.RED, 200);
        discsOnTowers[0][1] = new Disc(100, 250, Color.GREEN, 150);
        discsOnTowers[0][2] = new Disc(100, 200, Color.BLUE, 100);
        // Align discs on the first tower
        alignDiscToTower(0, 0);
        numDiscs[0]++;
        alignDiscToTower(1, 0);
        numDiscs[0]++;
        alignDiscToTower(2, 0);
        numDiscs[0]++;
    }

    /**
     * Aligns a disc to the specified tower.
     *
     * @param indexInDiscArray The index of the disc in the discsOnTowers array.
     * @param towerNumber The number of the tower to which the disc is to be aligned.
     */
    public void alignDiscToTower(int indexInDiscArray, int towerNumber) {
        int heightMod = numDiscs[towerNumber] * 50; // Calculate the vertical offset based on the number of discs
        discsOnTowers[towerNumber][indexInDiscArray].setCoords(
                (int) towers[towerNumber].frontEnd.getX()
                        - discsOnTowers[towerNumber][indexInDiscArray].getDiameter() / 2
                        + Tower.TOWER_WIDTH / 2,
                (int) towers[towerNumber].frontEnd.getY()
                        + Tower.TOWER_HEIGHT
                        - Disc.DISC_HEIGHT
                        - heightMod
        );
    }
}
