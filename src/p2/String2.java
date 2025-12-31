package p2;

public class String2 implements Editable{
    private String mainString;

    public String2(String s){
        setMainString(s);
    }

    @Override
    public void addPrefix(String s) {
        setMainString(s + mainString);
    }

    @Override
    public void addPostfix(String s) {
        setMainString(mainString + s);
    }

    public String toString(){
        return mainString;
    }

    public String getMainString() {
        return mainString;
    }

    public void setMainString(String mainString) {
        this.mainString = mainString;
    }
}
