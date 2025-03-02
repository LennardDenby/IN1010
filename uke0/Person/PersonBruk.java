public class PersonBruk {
    public static void main(String[] args) {
        Person p1 = new Person("Ola", 22);
        //Dette er en kommentar!
        
        System.out.println(p1.hent_alder());
        System.out.println(p1.hent_navn());
    }
}
