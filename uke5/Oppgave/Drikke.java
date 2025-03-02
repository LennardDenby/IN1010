public class Drikke implements Drikkbar {
    int drikke;
    int maksDrikke;

    public Drikke(int m) {
        maksDrikke = m;
        drikke = maksDrikke;
    }
    @Override
    public void drikkGlass() {
        drikke -= 2;
        if (drikke < 0) {
            drikke = 0;
        }
    }
    @Override
    public void fyllOpp() {
        drikke = maksDrikke;
    }
    public void skrivUtDrikke() {
        System.out.println(drikke);
    }

    @Override
    public String toString() {
        return "Drikke i flasken: "+drikke+", maks drikke: "+maksDrikke;
    }
}
