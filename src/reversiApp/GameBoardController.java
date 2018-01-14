package reversiApp;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class GameBoardController extends GridPane{
    private Board board;
    private static final int FREE = 0;
    private static final int FULL = 1;


    public GameBoardController(Board board) {
        this.board = board;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void draw() {
        //this.getChildren.clear;
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();
        int cellHeight = height / board.getSize();
        int cellwidth = 40; ///change
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                this.add(new Rectangle(cellwidth , cellHeight ,
                        Color.AQUA) , j ,i);
            }
        }
    }
}



