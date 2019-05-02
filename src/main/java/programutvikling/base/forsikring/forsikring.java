package programutvikling.base.forsikring;

public abstract class forsikring {
    private int arligpremie;
    private String dato;
    private int forsikringsbelop;


    public forsikring(int arligpremie, String dato, int forsikringsbelop) {
        this.arligpremie = arligpremie;
        this.dato = dato;
        this.forsikringsbelop = forsikringsbelop;
    }

    abstract void betingelser();
}
