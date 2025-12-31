package h1;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols){
        gridArray = new Cell[gridRows][gridCols];
        // init all cells
        for (int i = 0; i < gridRows; i++){
            for (int j = 0; j < gridCols; j++){
                gridArray[i][j] = new Cell(i,j); // init dead cell with index i,j
            }
        }
        for (Cell c : cells){ //set all cells in array to be alive
            gridArray[c.getIndexRow()][c.getIndexCol()].setAlive(true);
        }
    }

    public void computeNextGen(){}

    public void computeGeneration(int n){}

    public void outputGrid(){
        for (int i = 0; i < gridArray.length; i++){
            for (int j = 0; j < gridArray[i].length; j++){
                System.out.print(" " + cellToString(gridArray[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private String cellToString(Cell c){
        return c.isAlive() ? "1" : "0";
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
}
