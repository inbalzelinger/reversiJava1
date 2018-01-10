package reversiApp;

public class Point {
    private int row;
    private int col;


    public Point(int row , int col) {
        this.row = row;
        this.col = col;
    }

   public int getRow(){
        return this.row;
    }

   public int getCol() {
        return this.col;
    }


    public void PrintPoint() {
        System.out.print("(" + this.row + "," + this.col+")");
    }

    boolean ComparePoint(Point point) {
        return (this.col == point.getCol() && this.row == point.getRow());
    }

}

