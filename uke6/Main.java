public class Main {
    public static void main(String[] args) {
        LenkeListe liste = new LenkeListe();

        liste.leggTilBakerst("A");
        liste.leggTilBakerst("B");
        liste.leggTilBakerst("C");

        System.out.println(liste);

        liste.fjernBakerst();
        liste.fjernBakerst();
        liste.fjernBakerst();
        liste.fjernBakerst();
        

        System.out.println(liste);
    }
}
