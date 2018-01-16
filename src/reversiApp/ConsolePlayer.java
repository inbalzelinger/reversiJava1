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

    /**
     * constructor
     * @param gridPane
     * @param color
     * @param symbol
     */

    public ConsolePlayer(GridPane gridPane , Color color , Symbol symbol) {
        this.gridPane = gridPane;
        this.color = color;
        this.symbol = symbol;
    }


    /**
     * return a new circle in the player color
     * @return circle
     */
    public Circle getCircle(){
        Circle circle=new Circle(6,this.color);
        circle.setStroke(Color.BLACK);
        return circle;
}

    /**
     * return player color
     * @return this.color
     */
    public Color getColor() {
        return color;
    }

    /**
     * return player sign
     * @return this.symbol
     */
    public Symbol getSign() {
        return this.symbol;
        }


}
