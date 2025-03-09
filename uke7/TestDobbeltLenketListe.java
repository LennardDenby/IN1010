public class TestDobbeltLenketListe {
    public static void main(String[] args) {
        // Test 1: Tom liste
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();
        assert liste.antall() == 0 : "Antall skal være 0 for tom liste";
        assert liste.hentFørste() == null : "hentFørste skal returnere null for tom liste";
        assert liste.hentSiste() == null : "hentSiste skal returnere null for tom liste";
        assert liste.hent(0) == null : "hent(0) skal returnere null for tom liste";

        // Test 2: Sett inn først - ett element
        liste.settInnFørst("A");
        assert liste.antall() == 1 : "Antall skal være 1 etter å ha satt inn ett element først";
        assert liste.hentFørste().equals("A") : "hentFørste skal returnere A";
        assert liste.hentSiste().equals("A") : "hentSiste skal returnere A";
        assert liste.hent(0).equals("A") : "hent(0) skal returnere A";

        // Test 3: Sett inn sist - to elementer
        liste.settInnSist("B");
        assert liste.antall() == 2 : "Antall skal være 2 etter å ha satt inn et element sist";
        assert liste.hentFørste().equals("A") : "hentFørste skal fortsatt være A";
        assert liste.hentSiste().equals("B") : "hentSiste skal være B";
        assert liste.hent(0).equals("A") : "hent(0) skal returnere A";
        assert liste.hent(1).equals("B") : "hent(1) skal returnere B";
        assert liste.hent(2) == null : "hent(2) skal returnere null (utenfor grensen)";

        // Test 4: Fjern første - tilbake til ett element
        liste.fjernFørste();
        assert liste.antall() == 1 : "Antall skal være 1 etter å ha fjernet første";
        assert liste.hentFørste().equals("B") : "hentFørste skal være B etter fjerning";
        assert liste.hentSiste().equals("B") : "hentSiste skal være B etter fjerning";
        assert liste.hent(0).equals("B") : "hent(0) skal returnere B";

        // Test 5: Fjern siste - tom liste
        liste.fjernSiste();
        assert liste.antall() == 0 : "Antall skal være 0 etter å ha fjernet siste";
        assert liste.hentFørste() == null : "hentFørste skal returnere null etter tom liste";
        assert liste.hentSiste() == null : "hentSiste skal returnere null etter tom liste";

        // Test 6: Fjern fra tom liste
        liste.fjernFørste();
        assert liste.antall() == 0 : "Antall skal fortsatt være 0 etter fjernFørste på tom liste";
        liste.fjernSiste();
        assert liste.antall() == 0 : "Antall skal fortsatt være 0 etter fjernSiste på tom liste";

        // Test 7: Sett inn flere elementer og hent med indeks
        liste.settInnFørst("C");
        liste.settInnFørst("B");
        liste.settInnFørst("A");
        assert liste.antall() == 3 : "Antall skal være 3 etter flere innsettinger";
        assert liste.hent(0).equals("A") : "hent(0) skal returnere A";
        assert liste.hent(1).equals("B") : "hent(1) skal returnere B";
        assert liste.hent(2).equals("C") : "hent(2) skal returnere C";
        assert liste.hent(-1) == null : "hent(-1) skal returnere null (negativ indeks)";

        // Test 8: Fjern siste fra liste med flere elementer
        liste.fjernSiste();
        assert liste.antall() == 2 : "Antall skal være 2 etter å ha fjernet siste";
        assert liste.hentFørste().equals("A") : "hentFørste skal fortsatt være A";
        assert liste.hentSiste().equals("B") : "hentSiste skal være B etter fjernSiste";


        for (String s : liste) {
            System.out.println(s);
        }
        System.out.println("---Alle tester bestått!---");
    }
}