
public class PilotaThread extends Thread {
    private String nome;
    private Pista pista;

    public PilotaThread(String nome, Pista pista) {
        this.nome = nome;
        this.pista = pista;
    }

    @Override
    public void run() {
        try {
            pista.entrataSpogliatoio(nome);
            pista.entrataPista(nome);

            long tempoGara = (int) (Math.random() * 4000 + 2000);
            Thread.sleep(tempoGara);
            System.out.println(nome + " ha completato la gara con un tempo di " + tempoGara + " secondi");

            pista.uscitaPista(nome);
            pista.ritornoSpogliatoio(nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}