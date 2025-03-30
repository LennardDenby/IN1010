import java.util.concurrent.CountDownLatch;

public class HeiTraad implements Runnable {
    private CountDownLatch latch;
    private int antallHei;
    private int antallTraader;

    public HeiTraad(CountDownLatch latch, int antallHei, int antallTraader) {
        this.latch = latch;
        this.antallHei = antallHei;
        this.antallTraader = antallTraader;
    }
    @Override
    public void run() {
        for (int i = 1; i <= antallHei; i++) {
            System.out.println("Hei " + i);

            latch.countDown();
            while (latch.getCount() > (antallTraader * antallHei) - antallTraader * i) {

            }
        }
    }
    
}
