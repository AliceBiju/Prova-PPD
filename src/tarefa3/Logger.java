package tarefa3;

public class Logger {

    // synchronized para evitar mensagens misturadas no console
    public static synchronized void log(int id, String mensagem) {
        System.out.println("[T3 | Filosofo " + id + "] " + mensagem);
    }
}
