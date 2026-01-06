package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int living = 0;
        for (int i = this.indexRow - 1; i <= this.indexRow + 1; i++) {
            if (i >= 0 && i < gridArray.length) {
                for (int j = this.indexCol - 1; j <= this.indexCol + 1; j++) {
                    if (j >= 0 && j < gridArray[i].length) {
                        if (gridArray[i][j].isAlive() && gridArray[i][j] != this) {
                            living++;
                        }
                    }
                }
            }
        }
        this.numLivingNeighbors = living;
        decideNextStatus();
    }

    //private methods

    private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = !(numLivingNeighbors > 3) && !(numLivingNeighbors < 2);
        } else {
            isAliveNextGen = numLivingNeighbors == 3;
        }
    }

    //getter and setter

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }
}
