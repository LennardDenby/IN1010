public class Kasse implements Runnable {
    KøMonitor monitor;
    public Kasse(KøMonitor m) {
        monitor = m;
    }

    @Override
    public void run() {
        try {
            while (!monitor.erFerdig()) {
                Person p = monitor.hentPerson();
                System.out.println("Scanner varer til: "+p.hentNavn());
                for (String vare : p.hentVarer()) {
                    System.out.print(vare + " ");
                    Thread.sleep(1000);
                }
                System.out.println("✅");
            }
        } catch (InterruptedException e) {
            System.err.println(e);;
        }
    }
}
