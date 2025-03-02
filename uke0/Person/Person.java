public class Person {
    private String navn;
    private int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }
    public String hent_navn() {
        return this.navn;
    }
    public int hent_alder() {
        return this.alder;
    }
}