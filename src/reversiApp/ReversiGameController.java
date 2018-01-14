package reversiApp;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {

    @FXML Label labelVar;

    @FXML
    private HBox root;
    private Symbol currentPlayer;
    private ConsoleGameLogic logic;
    private Board board;
    private GameBoardController gameBoardController;

public ReversiGameController(){
    this.currentPlayer=Symbol.X;
    this.logic=new ConsoleGameLogic();
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
    this.board = new Board(size);
     this.gameBoardController = new GameBoardController(board,color1,color2);
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelVar.setText("its X turn");

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
        gameBoardController.setOnMouseClicked(event -> {
            System.out.println("click: ");
            Point point=gameBoardController.whichCell(event.getY(),event.getX());
            point.PrintPoint();
            boolean isPlay=this.playOneTurn(point,currentPlayer);
           if(isPlay){
              this.updateCurrentPlayer();
                System.out.println("yes");
            }
            gameBoardController.draw();
            event.consume();
});
    }
    private boolean playOneTurn(Point point,Symbol currentPlayer){
        ArrayList<Point> possibleMovesList = logic.PossibleMoves(currentPlayer,board);

        if (possibleMovesList.isEmpty()) {
            return true;
        }


        System.out.println("list: ");
        for(Point p: possibleMovesList) {
            p.PrintPoint();

        }
        if(!(isValidMove(point,possibleMovesList))) {
            return false;
        }
        else{
            this.board.addToBoard(point.getRow(), point.getCol(), currentPlayer);
            logic.upside(currentPlayer,point.getRow(),point.getCol(),board);
            return true;
        }
    }
    private boolean isValidMove(Point point,ArrayList<Point> possibleMovesList){
        for(Point p: possibleMovesList) {
            if (p.ComparePoint(point)) {
                return true;
            }
        }
        return false;

    }
     private void updateCurrentPlayer(){
        if (this.currentPlayer==Symbol.X){
            this.currentPlayer=Symbol.O;

            labelVar.setText("its O turn");

            return;
        }
        this.currentPlayer=Symbol.X;
         labelVar.setText("its X turn");
     }




    @FXML
    public void end(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("menuStyle.css");
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

