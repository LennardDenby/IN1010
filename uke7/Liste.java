interface Liste<T> extends Iterable<T> {
    public int antall();
    public void settInnFørst(T elem);
    public void settInnSist(T elem);
    public void fjernFørste();
    public void fjernSiste();
    public T hentFørste();
    public T hentSiste();
    public T hent(int indeks);
}
