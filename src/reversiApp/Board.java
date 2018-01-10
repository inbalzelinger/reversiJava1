package reversiApp;

public class Board {
    private int size;
   private Symbol[][] board;


    /**
     * constructor
     *
     * @param size size of  matrix
     */
   public Board(int size) {

        this.size = size;
        this.board = new Symbol[size][size];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = Symbol.EMPTY;
            }
        }

        this.board[size / 2][size / 2] = Symbol.O;
        this.board[(size / 2) - 1][(size / 2) - 1] = Symbol.O;
        this.board[size / 2][(size / 2) - 1] = Symbol.X;
        this.board[(size / 2) - 1][size / 2] = Symbol.X;

    }



    /**
     * return size of board
     *
     * @return this.size
     */
    public int getSize() {
        return this.size;
    }

    Symbol getValueAt(int row, int col) {
        return this.board[row][col];
    }

    /**
     * copy constructor
     *
     * @param boardToCopy
     */
    public Board(Board boardToCopy) {
        this.size = boardToCopy.size;
        this.board = new Symbol[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = boardToCopy.getValueAt(i, j);
            }
        }
    }

/*
    public void print (ostream &out ,const Board &board1)

    {
        char cellValue = ' ';
        out << " |";
        for (int i = 1; i <= board1.size; i++) {
            out << "  " << i << "  |";
        }
        out << endl;
        out << " ";
        for (int i = 0; i < board1.size * 3; i = i + 3) {
            out << "_ _ _ ";
        }
        out << endl;

        for (int i = 0; i < board1.size; i = i + 1) {
            for (int j = 0; j < board1.size; j = j + 1) {
                if (j == 0) {
                    out << i + 1 << "|";
                }
                if (board1.board[i][j] != empty) {
                    switch (board1.getValueAt(i, j)) {
                        case X:
                            cellValue = 'X';
                            break;
                        case O:
                            cellValue = 'O';
                            break;
                        case empty:
                            cellValue = ' ';
                            break;
                    }
                    out << cellValue << "    |";
                } else {
                    out << "     |";
                }
            }
            out << endl;
            out << " ";
            for (int i = 0; i < board1.size * 3; i = i + 3) {
                out << "_ _ _ ";
            }
            out << endl;
        }
        out << endl;
        return out;
    }
*/

    public int count(Symbol symbol) {
        int numSymbol = 0;
        for (int i = 0; i < this.size;i++){
            for (int j = 0; j < this.size;j++){
                if (this.board[i][j] == symbol){
                    numSymbol++;
                }
            }
        }
        return numSymbol;
    }

    public void addToBoard(int row, int col, Symbol playerSigh) {
        this.board[row - 1][col - 1] = playerSigh;
    }

}




