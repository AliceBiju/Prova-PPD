package tarefa4;

import java.util.Random;

public class Filosofo extends Thread {

    private final int id;
    private final Mesa mesa;
    private final Estatisticas stats;
    private final Random r = new Random();

    public Filosofo(int id, Mesa mesa, Estatisticas s) {
        this.id = id; this.mesa = mesa; this.stats = s;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 + r.nextInt(2000));
                mesa.pegar(id);

                Logger.log(id, "comendo...");
                stats.incrementa(id);
                Thread.sleep(1000 + r.nextInt(2000));

                mesa.soltar(id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
