import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Pista pista = new Pista();
        ArrayList<PilotaThread> piloti = new ArrayList<PilotaThread>();

        for (int i = 0; i < 8; i++) {
            String nomePilota = "Pilota " + i;
            PilotaThread pilota = new PilotaThread(nomePilota, pista);
            piloti.add(pilota);
        }

        for (PilotaThread pilota : piloti) {
            pilota.start();
        }
    }
}