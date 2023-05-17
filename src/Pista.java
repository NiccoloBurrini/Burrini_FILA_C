
public class Pista {
    private static final int MAX_KART = 4;
    private int kartInPista;

    public Pista() {
        this.kartInPista = 0;
    }

    public synchronized void entrataSpogliatoio(String nomePilota) throws InterruptedException {
        System.out.println(nomePilota + " è entrato nello spogliatoio e si sta indossando la tuta");
    }

    public synchronized void entrataPista(String nomePilota) throws InterruptedException {
        while (kartInPista >= MAX_KART) {
            System.out.println(nomePilota + " sta aspettando che un kart sia disponibile.");
            wait();
        }
        kartInPista++;
        System.out.println(nomePilota + " è entrato in pista. Kart in pista: " + kartInPista);

    }

    public synchronized void uscitaPista(String nomePilota) {
        kartInPista--;
        System.out.println(nomePilota + " ha lasciato la pista. Kart in pista: " + kartInPista);
        notifyAll();
    }

    public void ritornoSpogliatoio(String nomePilota) throws InterruptedException {
        System.out.println(nomePilota + " è tornato allo spogliatoio e sta indossando i vestiti");
    }
}
