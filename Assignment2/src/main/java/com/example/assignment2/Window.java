package com.example.assignment2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Window extends Application {
    Disc currentDraggedDisc;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        TowerController tc = new TowerController();
  //      Disc d = new Disc(50, 50, Color.BLUE, 100);

        currentDraggedDisc = tc.discsOnTowers[0][0];

        for (int i=0;i<3;i++) {
            pane.getChildren().add(tc.towers[i].frontEnd);
        }

        for (int i=0;i<3;i++) {
            int i1 = i;
            tc.discsOnTowers[0][i].frontEnd.setOnDragDetected((MouseEvent event) -> {
                setCurrentDraggedDisc(tc.discsOnTowers[0][i1]);
                Dragboard db = tc.discsOnTowers[0][i1].frontEnd.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString("Circle source text");
                db.setContent(content);
            });
            tc.discsOnTowers[0][i].frontEnd.setOnMouseDragged((MouseEvent event) -> {
                event.setDragDetect(true);
            });
            pane.getChildren().add(tc.discsOnTowers[0][i].frontEnd);
        }

        for (int i=0;i<3;i++) {
            int i1= i;
            tc.towers[i].frontEnd.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != tc.towers[i1].frontEnd && event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                }
            });
            tc.towers[i].frontEnd.setOnDragDropped((DragEvent event) -> {
                Dragboard db = event.getDragboard();
                if (db.hasString()) {
                    pane.getChildren().remove(currentDraggedDisc.frontEnd);
                    currentDraggedDisc.setCoords((int)tc.towers[i1].frontEnd.getX()
                                    - currentDraggedDisc.getDiameter()/2
                                    + Tower.TOWER_WIDTH/2,
                            (int)tc.towers[i1].frontEnd.getY()
                                    + Tower.TOWER_HEIGHT
                                    - Disc.DISC_HEIGHT);
                    event.setDropCompleted(true);
                    pane.getChildren().add(currentDraggedDisc.frontEnd);
                } else {
                    event.setDropCompleted(false);
                }
                event.consume();
            });
        }



        Scene scene = new Scene(pane, 1024, 800, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hanoi Towers");

        primaryStage.show();
    }

    public void setCurrentDraggedDisc(Disc d) {
        currentDraggedDisc = d;
    }


}