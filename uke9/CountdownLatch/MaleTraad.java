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
        try {
            Thread.sleep(1000);
            System.out.println(navn + " ferdig med å male");
            latch.countDown();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}
