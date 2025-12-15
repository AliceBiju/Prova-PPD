package tarefa4;

import java.util.LinkedList;
import java.util.Queue;

public class Mesa {

    private final boolean[] garfos = new boolean[5];
    private final Queue<Integer> fila = new LinkedList<>();

    public synchronized void pegar(int id) throws InterruptedException {
        int e = id;
        int d = (id + 1) % 5;

        fila.add(id);

        while (fila.peek() != id || garfos[e] || garfos[d]) {
            wait();
        }

        fila.remove();
        garfos[e] = garfos[d] = true;
    }

    public synchronized void soltar(int id) {
        int e = id;
        int d = (id + 1) % 5;

        garfos[e] = garfos[d] = false;
        notifyAll();
    }
}
