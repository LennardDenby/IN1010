public class BilMain {
    public static void main(String[] args) {
        Bil b1 = new Bil("Ford", "AB12345");
        Elbil eb1 = new Elbil("Tesla", "EL12345", 75);

        b1.tut();
        eb1.tut();
        System.out.println(eb1.hentMotorEffekt());

        System.out.println(b1 instanceof Bil);
        System.out.println(b1 instanceof Elbil);
        System.out.println(eb1 instanceof Elbil);
        System.out.println(eb1 instanceof Bil);
    }
}


