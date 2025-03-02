public class Person {
    private int alder;
    private String navn;

    public Person(int alder, String navn) {
        this.alder = alder;
        this.navn = navn;
    }

    public int hent_alder() {
        return this.alder;
    }
    public String hent_navn() {
        return this.navn;
    }
}
