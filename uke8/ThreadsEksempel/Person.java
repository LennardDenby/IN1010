public class Person {
    private String navn;
    private String[] varer;

    public Person(String n, String[] v) {
        navn = n;
        varer = v;
    }
    public String hentNavn() {
        return navn;
    }
    public String[] hentVarer() {
        return varer;
    }
}
