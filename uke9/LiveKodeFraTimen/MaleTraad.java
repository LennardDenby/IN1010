import java.util.concurrent.CountDownLatch;

public class MaleTraad implements Runnable {
    String navn;
    CountDownLatch latch;

    public MaleTraad(String n, CountDownLatch l) {
        navn = n;
        latch = l;
    }

    @Override
    public void run() {
        vent();
        System.out.println(navn + " ferdig med å male.");
        latch.countDown();
        
    }
    public static void vent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
