package tarefa4;

public class MainTarefa4 {

    public static void main(String[] args) throws InterruptedException {
        Mesa mesa = new Mesa();
        Estatisticas stats = new Estatisticas();

        for (int i = 0; i < 5; i++) {
            new Filosofo(i, mesa, stats).start();
        }

        Thread.sleep(120_000);
        stats.imprimir();
        System.exit(0);
    }
}
