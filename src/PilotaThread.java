
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
            String nomePilota = Thread.currentThread().getName();
            pista.entrataSpogliatoio(nome);
            pista.entrataPista(nome);

            long tempo = System.currentTimeMillis();

            for (int i = 0; i < 15; i++) {
                Thread.sleep((int) (Math.random() * 4000 + 2000));
                System.out.println("Il pilota " + nomePilota + " ha percorso il giro n " + (i + 1));
            }

            tempo = System.currentTimeMillis() - tempo;
            System.out.println(nome + " ha completato la gara con un tempo di " + tempo + " secondi");

            pista.uscitaPista(nome);
            pista.ritornoSpogliatoio(nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}