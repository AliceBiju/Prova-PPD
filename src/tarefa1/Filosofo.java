package tarefa1;

import java.util.Random;

public class Filosofo extends Thread {

    private final int id;
    private final Garfo esquerdo;
    private final Garfo direito;
    private final Random random = new Random();

    public Filosofo(int id, Garfo esquerdo, Garfo direito) {
        this.id = id;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    private void log(String msg) {
        System.out.println("[T1 | Filosofo " + id + "] " + msg);
    }

    @Override
    public void run() {
        try {
            while (true) {
                log("pensando...");
                Thread.sleep(1000 + random.nextInt(2000));

                log("tentando pegar garfo esquerdo " + esquerdo.getId());
                synchronized (esquerdo) {
                    log("pegou garfo esquerdo " + esquerdo.getId());

                    log("tentando pegar garfo direito " + direito.getId());
                    synchronized (direito) {
                        log("comendo...");
                        Thread.sleep(1000 + random.nextInt(2000));
                    }
                }

                log("terminou de comer.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
