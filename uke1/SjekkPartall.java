public class SjekkPartall {
    public static void main(String[] args) {
        //OPPGAVE: Skrive ut om tall-argumentet er partall eller oddetall
        //KODE:
        int num = Integer.parseInt(args[0]);
        //Dette er det samme som int(string) typekonvertering i python

        if (erPartall(num)) {
            System.out.println("Tallet " + num + " er et partall");
        } else {
            System.out.println("Tallet " + num + " er et oddetall");
        }

    }
    static Boolean erPartall(int num) {
        return num % 2 == 0;
    }
}
