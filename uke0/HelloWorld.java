import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hei! Hva heter du?");

        Scanner scanner = new Scanner(System.in);
        String navn = scanner.nextLine();

        System.out.println("Hei "+navn+", velkommen til IN1010!");
        scanner.close();
    }
}
