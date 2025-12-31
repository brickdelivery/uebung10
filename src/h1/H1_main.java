package h1;

public class H1_main {
    public static void main(String[] args){
        //tests
        Cell[] cells = new Cell[]{new Cell(1,3)};
        Grid g = new Grid(cells, 4,5);
        g.outputGrid();

    }
}
