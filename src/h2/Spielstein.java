package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public void go(int n) {

    }

    private boolean movesOut() {
        char currentDir = brett.getBrett()[currentRow][currentCol].getDirection();
        if (currentRow == 0 && currentDir == 'U')
            return true;
        if (currentRow == brett.getDim() - 1 && currentDir == 'D')
            return true;
        if (currentCol == 0 && currentDir == 'L')
            return true;
        if (currentCol == brett.getDim() - 1 && currentDir == 'R')
            return true;
        return false;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }
}
