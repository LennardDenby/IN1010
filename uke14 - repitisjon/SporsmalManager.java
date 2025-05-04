import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SporsmalManager {
    ArrayList<Sporsmal> spmListe = new ArrayList<>();
    int nåværendeSpm = 0;

    public SporsmalManager(String filnavn) {
        lesFil(filnavn);
    }
    private void lesFil(String filnavn) {
        try {
            Scanner scanner = new Scanner(new File(filnavn));

            while (scanner.hasNextLine()) {
                String linje = scanner.nextLine();
                String[] data = linje.split(",");
                String spmString = data[0];
                Boolean sant = data[1].equals("true");

                Sporsmal spm = new Sporsmal(spmString, sant);
                spmListe.add(spm);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
    public Sporsmal next() {
        if (nåværendeSpm >= spmListe.size() - 1) {
            return null;
        }
        return spmListe.get(nåværendeSpm++);
    }
    public String hentSpm() {
        return spmListe.get(nåværendeSpm).spm;
    }
    public Boolean hentSvar() {
        return spmListe.get(nåværendeSpm).riktigSvar;
    }
}
