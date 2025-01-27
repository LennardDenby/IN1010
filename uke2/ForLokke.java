public class ForLokke {
    public static void main(String[] args) {
        //Dette er en for løkke som teller fra 0 til 10
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
        //Dette er et array NB: STATISK!!!!
        String[] navnListe = {"Ole", "Lars", "Sara", "Karl"};

        //Dette er en for each loop
        for (String navn: navnListe) {
            System.out.println(navn);
        }

        //Dette er en while løkke
        int num = 0;
        while (num < 10) {
            System.out.println(num);
            num++;
        }
        //Statisk Array!! Hva printes ut her?!?!?!?
        int[] tallListe = new int[10];
        for (int tall: tallListe) {
            System.out.println(tall);
        }

        //Fylle inn tall:
        for (int i = 0; i < 10; i++) {
            tallListe[i] = i;
        }
        for (int tall : tallListe) {
            System.out.println(tall);
        }
    }
}
