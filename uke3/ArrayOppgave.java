import java.util.ArrayList;

public class ArrayOppgave {
    public static void main(String[] args) {
        //Oppgave a
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        for(int i : array) {
            System.out.println(i);
        }

        //Oppgave b og c
        ArrayList<Integer> liste = new ArrayList<Integer>();
        int sum = 0;

        for (int i = 9; i >= 0; i--) {
            liste.add(i);
        }
        for (int i : liste) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("Summen er: " + sum);
        
        //Oppgave d
        String output = "";

        for (int i : array) {
            output += i;
            System.out.println(output);
        }

        //Oppgave e
        String stjerner = "";
        for (int i = 0; i < 10; i ++) {
            stjerner += "*";
            System.out.println(stjerner);
        }

    }
}
