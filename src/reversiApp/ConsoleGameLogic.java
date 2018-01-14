package reversiApp;

import reversiApp.Symbol;

import java.util.ArrayList;

public class ConsoleGameLogic {

    /**
     * constructor
     */
    public ConsoleGameLogic(){}

    ArrayList<Point> PossibleMoves(Symbol playerSign , Board b) {
        ArrayList<Point> moves1 = new ArrayList<>();
        ArrayList<Point> playersOptions=new ArrayList<>();

        Symbol otherPlayer;
        int counter = 0;
        int counterCol = 0;
        int colForDiagnol = 0;
        if (playerSign == Symbol.X) {
            otherPlayer = Symbol.O;
        } else {
            otherPlayer = Symbol.X;
        }
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                counter = 0;
                if (b.getValueAt(i , j) == playerSign) {
                    //right side of 0
                    for (int col = j + 1; col < b.getSize(); col++) {
                        if (b.getValueAt(i , col) == playerSign) {
                            break;
                        } else if (b.getValueAt(i , col) == otherPlayer) {
                            counter++;
                        } else if (b.getValueAt(i , col) == Symbol.EMPTY) {
                            if (counter != 0) {
                                moves1.add(new Point(i + 1, col + 1));
                            }
                            break;
                        }
                    }
                    //left side of O
                    counter = 0;
                    for (int cool = j - 1; cool >= 0; cool--) {
                        if (b.getValueAt(i , cool) == playerSign) {
                            break;
                        } else if (b.getValueAt(i , cool)== otherPlayer) {
                            counter++;
                        } else if (b.getValueAt(i , cool) == Symbol.EMPTY) {
                            if (counter != 0) {
                                moves1.add(new Point(i + 1 , cool + 1 ));
                            }
                            break;
                        }
                    }
                    //down side
                    counter = 0;
                    for (int row = i + 1; row < b.getSize(); row++) {
                        if (b.getValueAt(row , j) == playerSign) {
                            break;
                        } else if (b.getValueAt(row , j) == otherPlayer) {
                            counter++;
                        } else if (b.getValueAt(row , j)== Symbol.EMPTY) {
                            if (counter != 0) {
                                moves1.add(new Point(row + 1 , j + 1));
                            }
                            break;
                        }
                    }
                    //up side
                    counter = 0;
                    for (int row = i - 1; row >= 0; row--) {
                        if (b.getValueAt(row , j) == playerSign) {
                            counter = 0;
                            break;
                        } else if (b.getValueAt(row , j)  == otherPlayer) {
                            counter++;
                        } else if (b.getValueAt(row , j) == Symbol.EMPTY) {
                            if (counter != 0) {
                                moves1.add(new Point(row + 1 , j + 1));
                                counter = 0;
                            }
                            break;
                        }
                    }
                    //south east
                    counterCol = 0;
                    colForDiagnol = j + 1;
                    for (int row = i + 1; row < b.getSize(); row++) {
                        if (colForDiagnol < b.getSize()) {
                            if (b.getValueAt(row , colForDiagnol) == playerSign) {
                                break;
                            } else if (b.getValueAt(row , colForDiagnol)  == otherPlayer) {
                                colForDiagnol++;
                                counterCol++;
                            } else if (b.getValueAt(row , colForDiagnol)  == Symbol.EMPTY) {
                                if (counterCol != 0){

                                    moves1.add(new Point(row + 1 , colForDiagnol + 1));
                                }
                                break;

                            }
                        }
                    }
                    //north east
                    counterCol = 0;
                    colForDiagnol = j + 1;
                    for (int row = i - 1; row >= 0; row--) {
                        if (colForDiagnol < b.getSize()) {
                            if (b.getValueAt(row , colForDiagnol)  == playerSign) {
                                counterCol = 0;
                                break;
                            } else if (b.getValueAt(row , colForDiagnol)  == otherPlayer) {
                                colForDiagnol++;
                                counterCol++;
                            } else if (b.getValueAt(row , colForDiagnol)  ==Symbol.EMPTY) {
                                if (counterCol != 0) {
                                    moves1.add(new Point(row + 1 , colForDiagnol + 1 ));
                                }
                                break;
                            }
                        }
                    }
                    //south west
                    counterCol = 0;
                    colForDiagnol = j - 1;
                    for (int row = i + 1; row < b.getSize(); row++) {
                        if (colForDiagnol > -1) {
                            if (b.getValueAt(row , colForDiagnol) == playerSign) {
                                break;
                            } else if (b.getValueAt(row , colForDiagnol) == otherPlayer) {
                                colForDiagnol--;
                                counterCol++;
                            } else if (b.getValueAt(row , colForDiagnol) == Symbol.EMPTY) {
                                if (counterCol != 0){
                                    moves1.add(new Point(row + 1 , colForDiagnol + 1));
                                }
                                break;
                            }
                        }
                    }
                    //north west
                    counterCol = 0;
                    colForDiagnol = j - 1;
                    for (int row = i - 1; row >= 0; row--) {
                        if (colForDiagnol > -1) {
                            if (b.getValueAt(row , colForDiagnol) == playerSign) {
                                break;
                            } else if (b.getValueAt(row , colForDiagnol) == otherPlayer) {
                                colForDiagnol--;
                                counterCol++;
                            } else if (b.getValueAt(row , colForDiagnol) == Symbol.EMPTY) {
                                if (counterCol != 0) {
                                    moves1.add(new Point(row + 1 , colForDiagnol + 1));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        int j = 0;
        int flag = 0;
        if (playersOptions.isEmpty() && !moves1.isEmpty()) {
            playersOptions.add(moves1.get(j));
            j++;
        }
        while (j < moves1.size()) {
            for (int i = 0; i < playersOptions.size(); i++) {
                if (playersOptions.get(i) == (moves1.get(i))) {
                    break;
                } else {
                    flag++;
                }
            }
            if (flag == playersOptions.size()) {
                playersOptions.add(moves1.get(j));
            }
            flag = 0;
            j++;
        }
        return moves1;
    }





    public void upside(Symbol playerSign ,  int row , int col , Board b) {
        Symbol otherPlayer;
        int counter = 0;
        if (playerSign == Symbol.X)  {
            otherPlayer = Symbol.O;
        } else {
            otherPlayer = Symbol.X;
        }
        // adds up
        for (int i = row ; i < b.getSize(); i++) {

            if (b.getValueAt(i , col - 1) == Symbol.EMPTY) {
                break;

            } else if(b.getValueAt(i , col - 1) == otherPlayer) {
                counter++;
            } else if (b.getValueAt(i , col - 1) == playerSign) {
                while (counter != 0) {
                    b.addToBoard(i - counter + 1 , col , playerSign);
                    counter--;
                }
                break;

            }
        }
        counter = 0;
        // adds down
        for (int i = row - 2 ; i >= 0 ; i--) {
            if (b.getValueAt(i , col - 1) == Symbol.EMPTY) {
                break;

            } else if(b.getValueAt(i , col - 1) == otherPlayer) {
                counter++;
            } else if (b.getValueAt(i , col - 1) == playerSign) {
                while (counter != 0) {
                    b.addToBoard(i + counter + 1 , col , playerSign);
                    counter--;
                }
                break;

            }
        }
        counter = 0;
        // adds left
        for (int i = col - 2 ; i >= 0 ; i--) {
            if (b.getValueAt(row - 1 , i) == Symbol.EMPTY) {
                break;
            } else if(b.getValueAt(row - 1 , i) == otherPlayer) {
                counter++;
            } else if (b.getValueAt(row - 1 , i) == playerSign) {
                while (counter != 0) {
                    b.addToBoard(row, i + counter + 1 , playerSign);
                    counter--;
                }
                break;

            }
        }

        counter = 0;
        // adds right
        for (int i = col ; i < b.getSize() ; i++) {
            if (b.getValueAt(row - 1 , i) == Symbol.EMPTY) {
                break;

            } else if(b.getValueAt(row - 1 , i) == otherPlayer) {
                counter++;
            } else if (b.getValueAt(row - 1 , i) == playerSign) {
                while (counter != 0) {
                    b.addToBoard(row , i , playerSign);
                    i--;
                    counter--;
                }
                break;

            }
        }

        counter = 0;
        // diagonal up left
        int j = col;
        for (int i = row ; i < b.getSize() ; i++) {
            if ( j < b.getSize()) {
                if (b.getValueAt(i , j) == Symbol.EMPTY) {
                    break;
                } else if(b.getValueAt(i , j) == otherPlayer) {
                    counter++;
                    j++;
                } else if (b.getValueAt(i , j) == playerSign) {
                    while (counter != 0) {
                        b.addToBoard(i  , j, playerSign);
                        j--;
                        i--;
                        counter--;
                    }
                    break;

                }
            }
        }
        // diagonal down right
        j = col - 2;
        counter = 0;
        for (int i = row - 2 ; i >= 0 ; i--) {
            if (j >= 0) {
                if (b.getValueAt(i , j) == Symbol.EMPTY) {
                    break;

                } else if(b.getValueAt(i , j) == otherPlayer) {
                    counter++;
                    j--;
                } else if (b.getValueAt(i , j) == playerSign) {
                    while (counter != 0) {
                        b.addToBoard(i + 2 , j + 2  , playerSign);
                        j++;
                        i++;
                        counter--;
                    }
                    break;

                }
            }
        }
        // diagonal down left
        j = col - 2;
        counter = 0;
        for (int i = row ; i < b.getSize() ; i++) {
            if ( j >= 0) {
                if (b.getValueAt(i , j) == Symbol.EMPTY) {
                    break;
                } else if(b.getValueAt(i , j) == otherPlayer) {
                    counter++;
                    j--;
                } else if (b.getValueAt(i , j)  == playerSign) {
                    while (counter != 0) {
                        b.addToBoard(i, j + 2  , playerSign);
                        j++;
                        i--;
                        counter--;
                    }
                    break;
                }

            }
        }
        j = col;
        counter = 0;
        for (int i = row - 2 ; i >= 0 ; i--) {
            if (j < b.getSize()) {

                if (b.getValueAt(i , j)  == Symbol.EMPTY) {
                    break;

                } else if(b.getValueAt(i , j)  == otherPlayer) {
                    counter++;
                    j++;
                } else if (b.getValueAt(i , j)  == playerSign) {
                    while (counter != 0) {
                        b.addToBoard(i + 2, j , playerSign);
                        j--;
                        i++;
                        counter--;
                    }
                    break;
                }
            }

        }
    }

}
