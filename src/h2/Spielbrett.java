package h2;

public class Spielbrett {
    private Feld[][] brett;
    int dim;

    public Spielbrett(int dim){
        this.dim = dim;
        brett = new Feld[dim][dim];
    }
}
