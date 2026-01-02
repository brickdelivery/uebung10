package h1;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols){
        gridArray = new Cell[gridRows][gridCols];
        for (int i = 0; i < gridRows; i++){ // init all cells
            for (int j = 0; j < gridCols; j++){
                gridArray[i][j] = new Cell(i,j);
            }
        }
        for (Cell c : cells){ //set all cells in array to alive
            if (isInBounds(c.getIndexRow(),c.getIndexCol(),gridArray)) {
                gridArray[c.getIndexRow()][c.getIndexCol()].setAlive(true);
            }
        }
        updateAllCells();
    }

    private void updateAllCells() {
        for (Cell[] arr : gridArray){ //compute all cells statuses
            for (Cell c : arr){
                c.countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen(){
        Cell[][] nextGen = new Cell[gridArray.length][gridArray[0].length];
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                nextGen[i][j] = new Cell(i,j);
                if(gridArray[i][j].isAliveNextGen()){
                    nextGen[i][j].setAlive(true);
                }
            }
        }
        for (int i = 0; i < nextGen.length; i++) {
            for (int j = 0; j < nextGen[i].length; j++) {
                gridArray[i][j].setAlive(nextGen[i][j].isAlive());
            }
        }
        updateAllCells();
    }

    public void computeGeneration(int n){
        while (n !=0 ){
            computeNextGen();
            n--;
        }
    }

    public void outputGrid(){
        for (int i = 0; i < gridArray.length; i++){
            for (int j = 0; j < gridArray[i].length; j++){
                System.out.print(" " + cellToString(gridArray[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //private methods

    private String cellToString(Cell c){
        return c.isAlive() ? "1" : "0";
    }

    private boolean isInBounds(int row, int col, Cell[][] gridArray) {
        return row >= 0 && row < gridArray.length && col >= 0 && col < gridArray[0].length;
    }

    //getter & setter

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
}
