public class Øl extends Drikke {
    public Øl(int m) {
        super(m);
    }
    @Override
    public void drikkGlass() {
        drikke -= 5;
        if (drikke < 0) {
            drikke = 0;
        }
    }
}
