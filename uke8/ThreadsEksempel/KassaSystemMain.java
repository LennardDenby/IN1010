public class KassaSystemMain {
    public static void main(String[] args) {
        int antKasser = 2000;
        Thread[] traader = new Thread[antKasser];
        KøMonitor monitor = new KøMonitor();

        //starter med 1 fylle inn kø tråd
        KøInngang køInngang = new KøInngang(monitor, "personer_stor.txt");
        Thread inngangTråd = new Thread(køInngang);
        inngangTråd.start();

        try {
            inngangTråd.join();
        } catch (InterruptedException e) {
            System.out.println("InngangTråd avbrutt: " + e);
        }
        
        long startTime = System.currentTimeMillis();

        //Oprette kassene våres
        for (int i = 0; i < antKasser; i++) {
            Kasse kasse = new Kasse(monitor);
            Thread kasseTråd = new Thread(kasse);
            kasseTråd.start();
            traader[i] = kasseTråd;
        }

        try {
            for (Thread traad : traader) {
                traad.join();
            }
        } catch(InterruptedException e) {
            System.out.println("Kassetråd avbrutt: " + e);
        }

        long endTime = System.currentTimeMillis();
        long durationSeconds = (endTime - startTime) / 1000;

        System.out.println("Tid brukt med " + antKasser + " kasser: " + durationSeconds + "s");
        
    }
}
