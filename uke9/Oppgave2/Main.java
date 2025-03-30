import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        final int ANTALL_TRAADER = 8;
        final int ANTALL_HEI = 3;

        Thread[] traader = new Thread[ANTALL_TRAADER];
        CountDownLatch latch = new CountDownLatch(ANTALL_TRAADER*ANTALL_HEI);

        for (int i = 0; i < ANTALL_TRAADER; i++) {
            HeiTraad runnable = new HeiTraad(latch, ANTALL_HEI, ANTALL_TRAADER);
            traader[i] = new Thread(runnable);
        }

        for (Thread traad : traader) {
            traad.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
