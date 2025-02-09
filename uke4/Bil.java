public class Bil {
    private String merke;
    private String regnummer;

    public Bil(String m, String r) {
        merke = m;
        regnummer = r;
    }
    public void tut() {
        System.out.println("tutut!!");
    }
    public void skrivUt() {
        System.out.println(merke+","+regnummer);
    }
}