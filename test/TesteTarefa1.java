package test;


import tarefa1.MainTarefa1;


public class TesteTarefa1 {
public static void main(String[] args) throws Exception {
System.out.println("Iniciando teste da Tarefa 1 (espera-se possível deadlock)...");
MainTarefa1.main(args);
Thread.sleep(30000); // 30 segundos
System.out.println("Teste da Tarefa 1 finalizado.");
}
}