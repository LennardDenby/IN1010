import java.util.ArrayList;
import java.util.Iterator;

public class LosninsforslagLennard {
    public static void main(String[] args) {

    }
}

interface Motordrevet {
    public int trekkraft();
    public String motortype();
}
abstract class Seilfly {
    String id;
    int gildetall;
    int vingespenn;
    Seilfly neste;
    Seilfly forrige;

    public Seilfly(String i, int g, int v) {
        id = i;
        gildetall = g;
        vingespenn = v;
    }

    public String hentId() {
        return id;
    }
    public int hentGlidetall() {
        return gildetall;
    }
    public int hentVingespenn() {
        return vingespenn;
    }
    public Integer størstSpennviddeR() {
        if (neste == null) return vingespenn;
        int nesteInt = neste.størstSpennviddeR();

        if (nesteInt > vingespenn) {
            return nesteInt;
        } else {
            return vingespenn;
        }
    }
}

class EkteSeilfly extends Seilfly {
    public EkteSeilfly(String i, int g, int v) {
        super(i, g, v);
    }
}

abstract class MotorSeilfly extends Seilfly implements Motordrevet {
    int trekkraft;
    String motortype;

    public MotorSeilfly(String i, int g, int v, int t, String m) {
        super(i, g, v);
        trekkraft = t;
        motortype = m;
    }
    @Override
    public int trekkraft() {
        return trekkraft;
    }

    @Override
    public String motortype() {
        return motortype;
    }
}

class TMG extends MotorSeilfly {
    public TMG(String i, int g, int v, int t, String m) {
        super(i ,g, v, t, m);
    }
}

class SLG extends MotorSeilfly {
    public SLG(String i, int g, int v, int t, String m) {
            super(i ,g, v, t, m);
        }
}

class SSG extends MotorSeilfly {
    public SSG(String i, int g, int v, int t, String m) {
            super(i ,g, v, t, m);
        }
}

class KonkuranseGruppe implements Iterable<Seilfly> {
    Seilfly forste;
    Seilfly siste;
    
    public KonkuranseGruppe() {

    }

    public void leggTil(Seilfly s) {
        if (forste == null) {
            forste = siste = s;
            return;
        }
        s.forrige = siste;
        siste.neste = s;
        siste = s;
    }

    public boolean erMed(String s) {
        Seilfly peker = forste;

        while (peker != null) {
            if (peker.id == s) return true;
            peker = peker.neste;
        }
        return false;
    }

    public Seilfly taUt(String s) {
        Seilfly peker = forste;
        while (peker != null) {
            if (peker.hentId().equals(s)) {
                if (peker == forste && peker == siste) {
                    forste = siste = null;
                } else if (peker == forste) {
                    forste = forste.neste;
                    forste.forrige = null;
                } else if (peker == siste) {
                    siste = siste.forrige;
                    siste.neste = null;
                } else {
                    peker.forrige.neste = peker.neste;
                    peker.neste.forrige = peker.forrige;
                }
                return peker;
            }
            peker = peker.neste;
        }
        return null;
    }

    @Override
    public SeilflyIterator iterator() {
        return new SeilflyIterator();
    }
    class SeilflyIterator implements Iterator<Seilfly> {
        Seilfly it = forste;

        @Override
        public boolean hasNext() {
            return it != null;
        }
        @Override
        public Seilfly next() {
            Seilfly temp = it;
            it = it.neste;
            return temp;
        }
    }

    public Seilfly[] hentEkteSeilfly() {
        int antEkteSeilfly = 0;
        for (Seilfly s : this) {
            if (s instanceof EkteSeilfly) {
                antEkteSeilfly++;
            }
        }
        Seilfly[] ekteSeilfy = new Seilfly[antEkteSeilfly];
        int index = 0;
        for (Seilfly s : this) {
            if (s instanceof EkteSeilfly) {
                ekteSeilfy[index] = s;
                index++;
            }
        }
        return ekteSeilfy;
    }
    public Integer besteGlidetall() {
        if (forste == null) return null;
        int maks = 0;
        for (Seilfly s : this) {
            if (s.gildetall > maks) {
                maks = s.gildetall;
            }
        }
        return maks;
    }

    public Integer størstSpennvidde() {
        if (forste == null) return null;
        return forste.størstSpennviddeR();
    }

    public int[] histogramSpennvidde() {
        int[] spennVidde = new int[100];

        for (Seilfly s : this) {
            int spenn = s.hentVingespenn();
            if (spenn >= 10 || spenn <= 99) {
                spennVidde[spenn] += 1;
            }
        }
        return spennVidde;
    }
}