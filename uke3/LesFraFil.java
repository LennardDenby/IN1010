import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LesFraFil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv inn filnavn: ");
        String filNavn = input.nextLine();
        input.close();

        try {
            File fil = new File(filNavn);
            Scanner filInnlesning = new Scanner(fil);

            while (filInnlesning.hasNextLine()) {
                Ord ord = new Ord(filInnlesning.nextLine());
                ord.skrivUtOrd();
            }
            filInnlesning.close();

        } catch (FileNotFoundException e) {
            System.err.println("Feil filnavn! " + e);
        }
    }
}
