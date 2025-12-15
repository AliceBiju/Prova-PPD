package test;


import tarefa3.MainTarefa3;


public class TesteTarefa3 {
public static void main(String[] args) throws Exception {
System.out.println("Iniciando teste da Tarefa 3 (semáforo)...");
MainTarefa3.main(args);
Thread.sleep(120000); // 2 minutos
System.out.println("Teste da Tarefa 3 finalizado com sucesso.");
}
}