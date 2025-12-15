package tarefa4;

import java.util.concurrent.atomic.AtomicInteger;

public class Estatisticas {

    private final AtomicInteger[] refeicoes;

    public Estatisticas() {
        refeicoes = new AtomicInteger[5];
        for (int i = 0; i < 5; i++) {
            refeicoes[i] = new AtomicInteger(0);
        }
    }

    public void incrementa(int id) {
        refeicoes[id].incrementAndGet();
    }

    public void imprimir() {
        System.out.println("\n=== Estatísticas Tarefa 4 ===");
        for (int i = 0; i < 5; i++) {
            System.out.println("Filosofo " + i + " comeu " + refeicoes[i].get() + " vezes");
        }
    }
}
