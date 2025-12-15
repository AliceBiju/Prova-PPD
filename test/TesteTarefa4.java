package test;


import tarefa4.MainTarefa4;


public class TesteTarefa4 {
public static void main(String[] args) throws Exception {
System.out.println("Iniciando teste da Tarefa 4 (monitor com fairness)...");
MainTarefa4.main(args);
Thread.sleep(120000); // 2 minutos
System.out.println("Teste da Tarefa 4 finalizado com sucesso.");
}
}