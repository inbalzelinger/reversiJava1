package reversiApp;

public class Point {
    private int row;
    private int col;

    /**
     * constructor
     * @param row
     * @param col
     */
    public Point(int row , int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * return point x index
     * @return this.row
     */
   public int getRow(){
        return this.row;
    }

    /**
     * return point y index
     * @return this.col
     */
   public int getCol() {
        return this.col;
    }

    /**
     * print the point
     */
    public void PrintPoint() {
        System.out.print("(" + this.row + "," + this.col+")");
    }

    /**
     * return true if point==this, else- return false
     * @param point
     * @return true if point==this, else- return false
     */
    boolean ComparePoint(Point point) {
        return (this.col == point.getCol() && this.row == point.getRow());
    }

}

