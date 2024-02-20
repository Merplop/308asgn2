package com.example.assignment2;

import javafx.scene.paint.Color;

public class TowerController {
    public Tower[] towers = new Tower[3];
    public Disc[][] discsOnTowers = new Disc[3][3];
    public int[] numDiscs = new int[3];

    public TowerController() {
        for (int i=0;i<3;i++) {
            towers[i] = new Tower(100+(200*i), 300);
        }
        discsOnTowers[0][0] = new Disc(100, 300, Color.RED, 200);
        discsOnTowers[0][1] = new Disc(100, 250, Color.GREEN, 150);
        discsOnTowers[0][2] = new Disc(100, 200, Color.BLUE, 100);
        alignDiscToTower(0, 0);
        numDiscs[0]++;
        alignDiscToTower(1, 0);
        numDiscs[0]++;
        alignDiscToTower(2, 0);
        numDiscs[0]++;
    }

    public void alignDiscToTower(int indexInDiscArray, int towerNumber) {
        int heightMod = numDiscs[towerNumber] * 50;
        discsOnTowers[towerNumber][indexInDiscArray].setCoords(
                (int)towers[towerNumber].frontEnd.getX()
                        - discsOnTowers[towerNumber][indexInDiscArray].getDiameter()/2
                        + Tower.TOWER_WIDTH/2,
                (int)towers[towerNumber].frontEnd.getY()
                        + Tower.TOWER_HEIGHT
                        - Disc.DISC_HEIGHT
                        - heightMod
                );
    }
}
