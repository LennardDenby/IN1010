public class Box<T> {
    private T innhold;

    public Box(T innhold) {
        this.innhold = innhold;
    }
    public T hentInnhold() {
        return innhold;
    }
    public void settInnhold(T innhold) {
        this.innhold = innhold;
    }
}


