public class Motorsykkel {
    private int kilometerstand = 0;
    private String registreringsnummer;
    private int produksjonsnummer;
    private static int teller = 0;

    public Motorsykkel(String r) {
        this.registreringsnummer = r;
        this.produksjonsnummer = teller++;
    }
    public int hentKilometerstand() {
        return this.kilometerstand;
    }
    public int hentProduksjonsnummer() {
        return this.produksjonsnummer;
    }
    //OPPGAVE IKKE FERDIG
}
