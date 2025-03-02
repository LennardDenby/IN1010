public class Elbil extends Bil {
    private int motorEffekt;
    
    public Elbil(String m, String r, int me) {
        super(m, r);
        motorEffekt = me;
    }
    public int hentMotorEffekt() {
        return motorEffekt;
    }
}


