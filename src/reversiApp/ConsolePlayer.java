package reversiApp;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import reversiApp.Point;
import reversiApp.Symbol;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;
import java.util.Scanner;

class ConsolePlayer {


    private GridPane gridPane;
    private Symbol symbol;
    private Color color;


    public ConsolePlayer(GridPane gridPane , Color color , Symbol symbol) {
        this.gridPane = gridPane;
        this.color = color;
        this.symbol = symbol;
    }


    public void draw(int col , int row) {
        Circle circle = new Circle(6 , this.color);
        gridPane.add(circle , col , row);
    }
public Circle getCircle(){
        return new Circle(6,this.color);
}


    public Point makeMove(ArrayList<Point> possibleMoves, Board b) {
        int col=0, row=0;
        int legalMoves = 0;
        while (legalMoves == 0) {
            Scanner scn = new Scanner(System.in);
            row = scn.nextInt();
            col = scn.nextInt();
            //check if the move is on the list.
            if (!(possibleMoves.contains(new Point(row, col)))) {
                System.out.println("your move is illegal, please try again");
            } else {
                break;
            }
        }
        possibleMoves.clear();
        return new Point(row,col);
    }


    public Symbol getSign() {
return this.symbol;
    }


}
