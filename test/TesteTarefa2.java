package test;


import tarefa2.MainTarefa2;


public class TesteTarefa2 {
public static void main(String[] args) throws Exception {
System.out.println("Iniciando teste da Tarefa 2 (prevenção de deadlock)...");
MainTarefa2.main(args);
Thread.sleep(120000); // 2 minutos
System.out.println("Teste da Tarefa 2 finalizado com sucesso.");
}
}