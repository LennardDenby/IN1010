import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KøMonitor {
    //personer som står i køen
    private ArrayList<Person> kø = new ArrayList<>();
    private Lock lås = new ReentrantLock();
    private Condition ikkeTom = lås.newCondition();
    private Boolean allePersonerLagtTil = false;

    public void leggTilIKø(Person p) {
        lås.lock();
        try {
            kø.add(p);
            System.out.println(p.hentNavn() + " ligger nå i kø.");
            ikkeTom.signal();
        } finally {
            lås.unlock();
        }
    }
    public Person hentPerson() throws InterruptedException {
        lås.lock();
        try {
            if (kø.isEmpty()) ikkeTom.await();
            return kø.removeFirst();
        } finally {
            lås.unlock();
        }
    }
    public void ferdigMedInnlegging() {
        lås.lock();
        try {
            allePersonerLagtTil = true;
            ikkeTom.signalAll();
        } finally {
            lås.unlock();
        }
    }
    public boolean erFerdig() {
        lås.lock();
        try {
            return allePersonerLagtTil && kø.isEmpty();
        } finally {
            lås.unlock();
        }
    }
}
