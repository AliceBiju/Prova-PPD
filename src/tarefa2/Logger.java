package tarefa2;

public class Logger {
    public static synchronized void log(int id, String msg) {
        System.out.println("[T2 | Filosofo " + id + "] " + msg);
    }
}
