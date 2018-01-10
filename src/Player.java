import java.util.ArrayList;

public abstract class Player {
    private Symbol sign;

    /**
     * constructor
     * @param currentSign
     */
    public Player(Symbol currentSign) {
        this.sign = currentSign;
    }

    /**
     * return player sign
     * @return this.sign
     */
    public Symbol getSign() {
        return this.sign;
    }

    /**
     * abstract method -make the player move.
     * @param possibleMoves
     * @param b
     * @return point the user chose to go
     */
    public abstract Point makeMove(ArrayList<Point> possibleMoves, Board b);
}










