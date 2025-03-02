public class Main {
    public static void main(String[] args) {
        Drikke d1 = new Drikke(4);
        System.out.println(d1);
        d1.drikkGlass();
        System.out.println(d1);
        d1.drikkGlass();
        d1.drikkGlass();
        System.out.println(d1);
        d1.skrivUtDrikke();
    }
}
