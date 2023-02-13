package lotto;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Loto6din49 {
    public static void main(String[] args) {
        Set<Integer> nrExtrase = new HashSet<>();
        Set<Integer> nrIncercate = new HashSet<>();
        Set<Integer> nrGasite = new HashSet<>();
        nrExtrase = extrageNumere();
        int nrG = 0;
        int nrIncercari = 0;
        while (nrG < 3) {
            nrIncercate = extrageNumere();
            System.out.println("Nr extrase: " + nrExtrase);
            System.out.println("Nr incercate: " + nrIncercate);
            nrGasite = verificBilet(nrIncercate, nrExtrase);

            nrG = nrGasite.size();

            System.out.println("Numerele gasite: " + nrGasite);
            nrIncercari++;
            System.out.println(nrG>=3 ? "Bilet castigator!! " + nrG+ " numere din " + nrIncercari + " incercari!" : "(Bilet necastigator)");

        }
        System.out.println();
    }


    public static Set<Integer> extrageNumere() {
        int nrExtras = 0;
        Set<Integer> setExtrase = new HashSet<>();
        while (setExtrase.size() <= 6) {
            nrExtras = new Random().nextInt(49);
            if (nrExtras != 0) {
                setExtrase.add(nrExtras);
            }
        }
        return setExtrase;
    }

    public static Set<Integer> verificBilet(Set<Integer> inc, Set<Integer> ext) {
        int nr = 0;
        Set<Integer> setGasite = new HashSet<>();
        Iterator<Integer> it = inc.iterator();
        while (it.hasNext()) {
            nr = it.next();
            if (ext.contains(nr)) {
                setGasite.add(nr);
            }
        }
        return setGasite;
    }
}
