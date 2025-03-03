public class LenkeListe {
    private Node forste;
    private Node siste;

    private class Node {
        Node neste;
        String data;
        public Node(String data) {this.data = data;}

    }
    public void leggTilBakerst(String data) {
        Node nyNode = new Node(data);

        if (forste == null) {
            forste = siste = nyNode;
            return;
        }

        siste.neste = nyNode;
        siste = nyNode;
    }
    public void fjernBakerst() {
        if (forste == null) return;
        if (forste == siste) {
            forste = siste = null;
            return;
        }

        Node peker = forste;

        while (peker.neste != siste) {
            peker = peker.neste;
        }
        peker.neste = null;
        siste = peker;
    }
    public void fjernForran() {
        if (forste == null) {
            return;
        }
        if (forste == siste) {
            forste = siste = null;
            return;
        }
        forste = forste.neste;
    }
    public void leggTilForran(String data) {
        Node nyNode = new Node(data);
        if (forste == null) {
            forste = siste = nyNode;
        }
        nyNode.neste = forste;
        forste = nyNode;
    }
    public void fjern(int indeks) {
        if (indeks == 0) {
            fjernForran();
            return;
        }
        Node peker = forste;
        for (int i = 0; i < indeks - 1; i++) {
            peker = peker.neste;
        }
        //Hva skjer om indeks er siste element?
        peker.neste = peker.neste.neste;

    }


    @Override
    public String toString() {
        String returnStr = "";
        Node peker = forste;

        while (peker != null) {
            returnStr += peker.data + "\n";
            peker = peker.neste;
        }
        return returnStr;
    }
}