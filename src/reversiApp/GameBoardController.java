package reversiApp;



import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class GameBoardController extends GridPane{
    private Board board;
    private Color color1;
    private Color color2;
    private ConsolePlayer playerX;
    private ConsolePlayer playerO;


    private static final int FREE = 0;
    private static final int FULL = 1;

    /**
     * constructor
     * @param board
     * @param color1
     * @param color2
     */
    public GameBoardController(Board board,Color color1,Color color2) {
        this.board = board;
        this.color1=color1;
        this.color2=color2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        playerX = new ConsolePlayer(this , color1, Symbol.X);
        playerO = new ConsolePlayer(this , color2 , Symbol.O);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * draw the board
     */
    public void draw() {
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();
        int cellHeight = height / board.getSize();
        int cellwidth = cellHeight;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Rectangle rectangle=new Rectangle(cellwidth , cellHeight , Color.BEIGE);
                rectangle.setStroke(Color.BLACK);
                this.add(rectangle, j ,i);
                if(board.getValueAt(i,j)!=Symbol.EMPTY) {
                    Circle playerCircle=null;
                    if (board.getValueAt(i, j) == playerX.getSign()) {
                        playerCircle = playerX.getCircle();
                    } else if (board.getValueAt(i, j) == playerO.getSign()) {
                        playerCircle = playerO.getCircle();
                    }
                    this.add(playerCircle, j, i);
                    setHalignment(playerCircle, HPos.CENTER);
                }

            }
        }
    }

    /**
     * calculate at which cell the mouse clicked
     * @param row
     * @param col
     * @return cell the user clicked on
     */
    public Point whichCell(double row, double col){
        int numOfCells=board.getSize();
        double cellSize=this.getPrefHeight()/numOfCells;
        int r= (int) ((int)row/cellSize);
        int c= (int) ((int)col/cellSize);
        return new Point(r+1,c+1);

        }

    public ConsolePlayer getPlayerO() {
        return playerO;
    }

    public ConsolePlayer getPlayerX() {
        return playerX;
    }
}






