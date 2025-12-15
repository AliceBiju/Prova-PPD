package tarefa2;

import java.util.Random;

public class Filosofo extends Thread {

    private final int id;
    private final Garfo esquerdo, direito;
    private final boolean invertido;
    private final Estatisticas stats;
    private final Random random = new Random();

    public Filosofo(int id, Garfo e, Garfo d, boolean invertido, Estatisticas stats) {
        this.id = id;
        this.esquerdo = e;
        this.direito = d;
        this.invertido = invertido;
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Logger.log(id, "pensando...");
                Thread.sleep(1000 + random.nextInt(2000));

                if (invertido) pegarInvertido();
                else pegarNormal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pegarNormal() throws InterruptedException {
        synchronized (esquerdo) {
            synchronized (direito) {
                comer();
            }
        }
    }

    private void pegarInvertido() throws InterruptedException {
        synchronized (direito) {
            synchronized (esquerdo) {
                comer();
            }
        }
    }

    private void comer() throws InterruptedException {
        Logger.log(id, "comendo...");
        stats.incrementa(id);
        Thread.sleep(1000 + random.nextInt(2000));
    }
}
