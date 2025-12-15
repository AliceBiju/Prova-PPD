package tarefa4;

public class Logger {

    // synchronized evita mensagens misturadas entre threads
    public static synchronized void log(int id, String mensagem) {
        System.out.println("[T4 | Filosofo " + id + "] " + mensagem);
    }
}
