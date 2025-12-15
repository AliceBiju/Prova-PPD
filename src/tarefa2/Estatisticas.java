package tarefa2;

import java.util.concurrent.atomic.AtomicInteger;

public class Estatisticas {
    private final AtomicInteger[] refeicoes = new AtomicInteger[5];

    public Estatisticas() {
        for (int i = 0; i < 5; i++) refeicoes[i] = new AtomicInteger();
    }

    public void incrementa(int id) {
        refeicoes[id].incrementAndGet();
    }

    public void imprimir() {
        System.out.println("\n=== Estatísticas Tarefa 2 ===");
        for (int i = 0; i < 5; i++) {
            System.out.println("Filosofo " + i + ": " + refeicoes[i].get());
        }
    }
}
