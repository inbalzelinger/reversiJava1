import java.util.ArrayList;
import java.util.Scanner;

class ConsolePlayer extends Player {
    /**
     * constructor
     * @param currentPlayer
     */
    public ConsolePlayer(Symbol currentPlayer) {
        super(currentPlayer);
    }

   @Override
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
}
