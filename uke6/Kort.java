public class Kort implements Betalingsmetode {
    public void betal(double pris) {
        System.out.println("Betaler: "+pris+"kr med kort");
    }
}
