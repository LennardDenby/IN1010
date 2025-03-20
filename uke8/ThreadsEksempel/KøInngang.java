import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KøInngang implements Runnable {
    KøMonitor monitor;
    String filnavn;

    public KøInngang (KøMonitor m, String f) {
        monitor = m;
        filnavn = f;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String navn = data[0];

                int antVarer = data.length - 1;
                String[] varer = new String[antVarer];

                for (int i = 1; i <= antVarer; i++) {
                    varer[i-1] = data[i];
                }
                Person p = new Person(navn, varer);

                monitor.leggTilIKø(p);
            }
            scanner.close();
            monitor.ferdigMedInnlegging();
            
        } catch (FileNotFoundException e) { //interrupted exception?
            System.err.println(e);
        }
    }
}
