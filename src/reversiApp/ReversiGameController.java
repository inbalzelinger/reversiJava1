package reversiApp;

import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    private HBox root;
    private int[][] maze = {
            {0,1,0,1,0,0,0,1,0,0,0},
            {0,1,0,1,0,0,0,1,0,0,0}
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Board board=new Board(8);
        GameBoardController gameBoardController=new GameBoardController(board);
        gameBoardController.setPrefHeight(400);
        gameBoardController.setPrefWidth(400);
        root.getChildren().add(0,gameBoardController);
        gameBoardController.draw();

    }
}
