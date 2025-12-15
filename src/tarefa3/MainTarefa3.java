package tarefa3;

import java.util.concurrent.Semaphore;

public class MainTarefa3 {

    public static void main(String[] args) throws InterruptedException {
        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) garfos[i] = new Garfo(i);

        Semaphore sem = new Semaphore(4);
        Estatisticas stats = new Estatisticas();

        for (int i = 0; i < 5; i++) {
            new Filosofo(i, garfos[i], garfos[(i+1)%5], sem, stats).start();
        }

        Thread.sleep(120_000);
        stats.imprimir();
        System.exit(0);
    }
}
