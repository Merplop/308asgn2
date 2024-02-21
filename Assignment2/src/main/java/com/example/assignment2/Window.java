package com.example.assignment2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class represents the main window for the Hanoi Towers game. It sets up the game's GUI
 * and initializes the game logic.
 */
public class Window extends Application {
    // The currently dragged disc in the game
    Disc currentDraggedDisc;

    /**
     * The main entry point for all JavaFX applications. The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * @param args the command line arguments passed to the application.
     *             An application may get these parameters using the getParameters() method.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the primary stage of the application, setting up the game's scene and initializing
     * game components.
     *
     * @param primaryStage the primary stage for this application, onto which the application scene can be set.
     */
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        TowerController tc = new TowerController();

        currentDraggedDisc = tc.discsOnTowers[0][0];

        // Add towers to the pane
        for (int i = 0; i < 3; i++) {
            pane.getChildren().add(tc.towers[i].frontEnd);
        }

        // Made by Luis Rodriguez
        // Setup disc dragging behavior
        for (int i = 0; i < 3; i++) {
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

        // Setup tower drag-over behavior
        for (int i = 0; i < 3; i++) {
            int i1 = i;
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
                    currentDraggedDisc.setCoords((int) tc.towers[i1].frontEnd.getX() - currentDraggedDisc.getDiameter() / 2 + Tower.TOWER_WIDTH / 2, (int) tc.towers[i1].frontEnd.getY() + Tower.TOWER_HEIGHT - Disc.DISC_HEIGHT);
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

    /**
     * Sets the current dragged disc in the game to the specified disc.
     *
     * @param d the disc to set as the current dragged disc.
     */
    public void setCurrentDraggedDisc(Disc d) {
        currentDraggedDisc = d;
    }
}
