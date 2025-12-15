package tarefa2;

public class MainTarefa2 {

    public static void main(String[] args) throws InterruptedException {
        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) garfos[i] = new Garfo(i);

        Estatisticas stats = new Estatisticas();

        for (int i = 0; i < 5; i++) {
            boolean invertido = (i == 4);
            new Filosofo(i, garfos[i], garfos[(i+1)%5], invertido, stats).start();
        }

        Thread.sleep(120_000);
        stats.imprimir();
        System.exit(0);
    }
}
