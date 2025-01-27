public class Eksempler {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
        String[] navnListe = {"Ole", "Lars", "Sara"};
        for (String navn : navnListe) {
            System.out.println(navn);
        }
        int[] tallListe = new int[10];
        for (int i = 0; i < 10; i++) {
            tallListe[i] = i;
        }
        for (int tall : tallListe) {
            System.out.println(tall);
        }
        int num = 0;
        while (num < 10) {
            System.out.println(num);
            num++;
        }

        if (tallListe.length == 10) {
            System.out.println("Lengden på arrayet er 10");
        }

        String navn = "Ola";
        System.out.println(navn == "Ola"); //IKKE GJØR DETTE
        System.out.println(navn.equals("Ola")); //GJØR DETTE
    }
    
}
