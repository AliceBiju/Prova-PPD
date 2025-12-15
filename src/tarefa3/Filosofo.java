package tarefa3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {

    private final int id;
    private final Garfo e, d;
    private final Semaphore sem;
    private final Estatisticas stats;
    private final Random r = new Random();

    public Filosofo(int id, Garfo e, Garfo d, Semaphore sem, Estatisticas s) {
        this.id = id; this.e = e; this.d = d; this.sem = sem; this.stats = s;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 + r.nextInt(2000));
                sem.acquire();

                synchronized (e) {
                    synchronized (d) {
                        Logger.log(id, "comendo...");
                        stats.incrementa(id);
                        Thread.sleep(1000 + r.nextInt(2000));
                    }
                }

                sem.release();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
