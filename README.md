# PROVA - Jantar dos Filósofos – Programação Paralela e Distribuída

## Descrição Geral

Este repositório apresenta a implementação do clássico problema do **Jantar dos Filósofos**, explorando diferentes estratégias de sincronização em sistemas concorrentes e distribuídos.

O projeto foi dividido em **quatro implementações práticas**, cada uma abordando um mecanismo distinto de controle de concorrência, além de um **relatório comparativo final** com análise crítica baseada em métricas coletadas durante a execução.

---

## Objetivos do Projeto

* Demonstrar problemas clássicos de concorrência (*deadlock* e *starvation*)
* Aplicar técnicas de sincronização em Java
* Comparar diferentes abordagens de controle concorrente
* Utilizar corretamente:

  * `synchronized`
  * `wait()` / `notifyAll()`
  * `Semaphore`
  * Monitores
* Coletar estatísticas de execução
* Produzir documentação técnica e análise comparativa

---

## Estrutura do Repositório

```
Prova-PPD/
├── README.md                 
├── RELATORIO.md              # Relatório comparativo (Tarefa 5)
│
├── src/
│   ├── tarefa1/              # Implementação com deadlock
│   │     ├── Filosofo.java
│   │     ├── Garfo.java
│   │     └── MainTarefa1.java
│   │
│   ├── tarefa2/              # Prevenção de deadlock (ordem diferente)
│   │     ├── Filosofo.java
│   │     ├── Garfo.java
│   │     ├── MainTarefa2.java
│   │     ├── Estatisticas.java
│   │     └── Logger.java
│   │
│   ├── tarefa3/              # Solução com semáforos
│   │     ├── Filosofo.java
│   │     ├── Garfo.java
│   │     ├── MainTarefa3.java
│   │     ├── Estatisticas.java
│   │     └── Logger.java
│   │
│   ├── tarefa4/              # Solução com monitor e fairness
│   │     ├── Mesa.java       # Monitor centralizado
│   │     ├── Filosofo.java
│   │     ├── MainTarefa4.java
│   │     ├── Estatisticas.java
│   │     └── Logger.java
│
├── test/                     # Testes unitários
│   ├── TesteTarefa1.java
│   ├── TesteTarefa2.java
│   ├── TesteTarefa3.java
│   └── TesteTarefa4.java
```

---

## Descrição das Tarefas

### Tarefa 1 – Implementação Básica com Deadlock

* Uso direto de `synchronized` nos garfos
* Todos os filósofos pegam os garfos na mesma ordem
* Possibilidade real de *deadlock*
* Sistema de logging detalhado

**Objetivo:** demonstrar explicitamente o problema de deadlock.

---

### Tarefa 2 – Prevenção de Deadlock (Ordem Diferente)

* Um filósofo pega os garfos em ordem inversa
* Eliminação da condição de espera circular
* Estatísticas de refeições por filósofo

**Objetivo:** prevenir deadlock com mínima modificação estrutural.

---

### Tarefa 3 – Solução com Semáforos

* Uso de `Semaphore` para limitar filósofos concorrentes
* No máximo **4 filósofos** tentando comer simultaneamente
* Deadlock prevenido por controle global de acesso

**Objetivo:** demonstrar o uso de semáforos como mecanismo de sincronização.

---

### Tarefa 4 – Solução com Monitor e Fairness

* Classe `Mesa` atua como monitor centralizado
* Uso de `wait()` e `notifyAll()`
* Garantia de fairness (evita starvation)
* Prevenção total de deadlock e starvation

**Objetivo:** garantir justiça e controle refinado de concorrência.

---

## Estatísticas Coletadas

Durante a execução das tarefas 2, 3 e 4 são coletadas:

* Número de vezes que cada filósofo comeu
* Distribuição das oportunidades de execução
* Base para cálculo de fairness

As estatísticas são exibidas automaticamente ao final da execução.

---

## 📄 Relatório Final

O arquivo **RELATORIO.md** contém:

* Introdução ao problema do Jantar dos Filósofos
* Metodologia dos testes realizados
* Tabelas comparativas das métricas
* Análise crítica das soluções
* Discussão sobre:

  * Prevenção de deadlock
  * Prevenção de starvation
  * Performance e throughput
  * Complexidade de implementação
  * Uso de recursos

---

## Tecnologias Utilizadas

* Java 8+
* Threads
* Monitores (`synchronized`, `wait`, `notifyAll`)
* Semáforos (`java.util.concurrent.Semaphore`)
* Programação concorrente

---

## Como Compilar e Executar

### Pré-requisitos

* Java JDK 8 ou superior
* Terminal

---

### Compilação

Na raiz do projeto, execute:

```bash
javac src/tarefaX/*.java
```

(Substitua `tarefaX` por `tarefa1`, `tarefa2`, `tarefa3` ou `tarefa4`)

---

### Execução

```bash
java -cp src tarefaX.MainTarefaX
```

Exemplos:

```bash
java -cp src tarefa1.MainTarefa1
java -cp src tarefa2.MainTarefa2
java -cp src tarefa3.MainTarefa3
java -cp src tarefa4.MainTarefa4
```

---
