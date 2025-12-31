package p1;

public class P1_main {
    public static void main(String[] args){
        Betrag a = new Betrag(1,80);
        Betrag b = new Betrag(1,80);
        Betrag c = summe(a,b);
    }

    public static Betrag summe(Betrag a, Betrag b){
        Betrag sum = new Betrag(0,0);
        sum.setEuro(a.getEuro() + b.getEuro());
        sum.setCent(a.getCent() + b.getCent());
        return sum;
    }
}
