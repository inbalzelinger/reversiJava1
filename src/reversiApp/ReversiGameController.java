package reversiApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File settingsFile = new File("settings.txt");
        BufferedReader reader = null;
        int size=8;
        Color color1=Color.BLACK;
        Color color2=Color.WHITE;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(settingsFile)));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            color1 = Color.valueOf(line);
            line = reader.readLine();
            color2=Color.valueOf(line);
            line = reader.readLine();
            size=Integer.parseInt(line);
        } catch (Exception e) {
            ;
        }

        Board board = new Board(size);
        GameBoardController gameBoardController = new GameBoardController(board,color1,color2);
        gameBoardController.setPrefHeight(400);
        gameBoardController.setPrefWidth(400);
        root.getChildren().add(0,gameBoardController);
        root.widthProperty().addListener(((observable, oldValue, newValue) -> {
            double boardNewWidth=newValue.doubleValue()-120;
            gameBoardController.setPrefWidth(boardNewWidth);
            gameBoardController.draw();
        }));

        root.heightProperty().addListener(((observable, oldValue, newValue) -> {
        gameBoardController.setPrefHeight(newValue.doubleValue());
        gameBoardController.draw();
    }));

    }
}
