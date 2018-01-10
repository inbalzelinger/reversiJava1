package reversiApp;

import java.util.ArrayList;

public class Game {
    private ConsoleGameLogic logic;
    private Board board;
    private Display display;
    private Player blackPlayer;
    private Player whitePlayer;

    /**
     *
     * @param b
     * @param Display
     */
    public Game(Board b,Display Display){
            this.logic=new ConsoleGameLogic();
            this.board=b;
            this.blackPlayer = new ConsolePlayer(Symbol.X);
            this.whitePlayer = new ConsolePlayer(Symbol.O);
    }

    public ArrayList<Point> turn(Symbol playerSign) {

        ArrayList<Point> playersOptions = this.logic.PossibleMoves(playerSign, this.board);
        boolean isPossibleToMove=!playersOptions.isEmpty();
      //  display.showTurnMessage(playerSign,isPossibleToMove,this.board);
        return playersOptions;
    }


    public void play() {
        int numX = 0;
        int numO = 0;
        Point p;
        ArrayList<Point> optionsBlack;
        ArrayList<Point> optionsWhite;
        while (board.count(this.blackPlayer.getSign()) != 0 &&
                (board.count(this.whitePlayer.getSign()) != 0)) {
            optionsBlack = this.turn(this.blackPlayer.getSign());
            if (!optionsBlack.isEmpty()) {
              //  Display.showStepsOptions(optionsBlack);
                p = blackPlayer.makeMove(optionsBlack, this.board);
                this.board.addToBoard(p.getRow(), p.getCol(), blackPlayer.getSign());
                this.logic.upside(blackPlayer.getSign(), p.getRow(), p.getCol(), this.board);
            }
            optionsWhite = this.turn(this.whitePlayer.getSign());
            if (!optionsWhite.isEmpty()) {
               // display.showStepsOptions(optionsWhite);
                p = whitePlayer.makeMove(optionsWhite,this.board);
                this.board.addToBoard(p.getRow(), p.getCol(), whitePlayer.getSign());
                this.logic.upside(whitePlayer.getSign(), p.getRow(), p.getCol(), this.board);
            }
            if (optionsBlack.isEmpty() && optionsWhite.isEmpty()||
                    (board.count(blackPlayer.getSign())+board.count(whitePlayer.getSign()))==board.getSize()*board.getSize()) {
                break;
            }
        }
        numX = board.count(this.blackPlayer.getSign());
        numO = board.count(this.whitePlayer.getSign());
       // display.printBoard(board);
        Symbol winnerSymbol=Symbol.EMPTY;
        int winnerScore=0;
        if (numX > numO) {
            winnerSymbol=Symbol.X;
            winnerScore=numX;
        } else if (numO > numX) {
            winnerSymbol=Symbol.O;
            winnerScore=numO;
        }
       // display.showEndingStatus(winnerSymbol,winnerScore);
    }






}
