package reversiApp;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class ReversiGameController implements Initializable {

    @FXML Label labelVar;
    @FXML Label XScore;
    @FXML Label OScore;
    @FXML Label Winner;
    @FXML Label gameOver;


    private  Integer numX;
    private Integer numO;





    @FXML
    private HBox root;
    private Symbol currentPlayer;
    private ConsoleGameLogic logic;
    private Board board;
    private GameBoardController gameBoardController;
    private int didntPlay;


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
    this.didntPlay = 0;
        labelVar.setText("its X turn");
        XScore.setText("X score: 2");
        OScore.setText("O score: 2");
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
        gameBoardController.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("click: ");
            Point point=gameBoardController.whichCell(event.getY(),event.getX());
            point.PrintPoint();
            boolean isPlay = this.playOneTurn(point,currentPlayer);
            boolean endOfGame = false;
           if(isPlay){
               endOfGame = this.updateCurrentPoints();
                System.out.println("yes");
            }
           if (this.didntPlay == 2) {
               System.out.println("end no Moves");
               this.updateWinner();


           }
            if (endOfGame) {
                this.updateWinner();
                ///change to game Over.
            }

            gameBoardController.draw();
            event.consume();
});
    }
    private boolean playOneTurn(Point point,Symbol currentPlayer){
        ArrayList<Point> possibleMovesList = logic.PossibleMoves(currentPlayer,board);
        if (possibleMovesList.isEmpty()) {
            this.updateCurrentPlayer();
            didntPlay++;
            return false;
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
            this.updateCurrentPlayer();
            this.didntPlay = 0;
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


    private boolean updateCurrentPoints(){
    this.numX = this.board.count(Symbol.X);
   this.numO = this.board.count(Symbol.O);

    XScore.setText("X score:" +numX.toString());
    OScore.setText("O score:" +numO.toString());
    if (numX + numO == (board.getSize() * board.getSize())) {
        return true;
        }
        else {
        return false;
        }
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


    public void updateWinner() {
    this.gameOver.setText("GAME OVER");
        if (this.numX > this.numO) {
            this.Winner.setText("the winner is: X");
        } else if (this.numO > this.numX) {
            this.Winner.setText("the winner is: O");
        } else {
            this.Winner.setText("its a tie");
        }
    }





}

