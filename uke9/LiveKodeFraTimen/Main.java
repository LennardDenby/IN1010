import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);

        MaleTraad maler1 = new MaleTraad("Picasso", latch);
        MaleTraad maler2 = new MaleTraad("Da Vinci", latch);
        MaleTraad maler3 = new MaleTraad("Van Gogh", latch);
        MaleTraad maler4 = new MaleTraad("Dali", latch);

        Thread t1 = new Thread(maler1);
        Thread t2 = new Thread(maler2);
        Thread t3 = new Thread(maler3);
        Thread t4 = new Thread(maler4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("Ferdig");

    }
}
