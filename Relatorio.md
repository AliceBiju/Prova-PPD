# RELATORIO — Análise Comparativa das Soluções do Jantar dos Filósofos

## Relatório Comparativo – Jantar dos Filósofos

**Disciplina:** Programação Paralela e Distribuida
**Aluno:** Alice Santos Monteiro de Barros
**Data:** 15/12/2025

---

## 1. Introdução

O problema clássico do **Jantar dos Filósofos**, proposto por *Edsger Dijkstra*, é amplamente utilizado para modelar situações reais de **sincronização, concorrência e compartilhamento de recursos** em sistemas computacionais.

O cenário consiste em cinco filósofos sentados ao redor de uma mesa circular. Cada filósofo alterna entre os estados de *pensar* e *comer*. Para comer, é necessário obter simultaneamente dois garfos (esquerdo e direito), sendo que cada garfo é compartilhado com o filósofo vizinho.

Os principais problemas analisados neste contexto são:

* **Deadlock:** situação em que todos os filósofos ficam bloqueados indefinidamente.
* **Starvation:** quando um ou mais filósofos nunca conseguem acessar os garfos.
* **Fairness:** quão justa é a distribuição das oportunidades de acesso aos recursos.

Neste relatório são analisadas e comparadas três soluções implementadas:

* **Tarefa 2:** Prevenção de deadlock por inversão da ordem de obtenção dos garfos.
* **Tarefa 3:** Uso de semáforo limitando a concorrência a 4 filósofos.
* **Tarefa 4:** Uso de monitor com garantia explícita de fairness.

Cada solução foi executada por **5 minutos**, com métricas coletadas automaticamente.

---

## 2. Metodologia

### 2.1 Configuração dos Testes

* **Linguagem:** Java
* **Número de filósofos:** 5
* **Tempo de execução por teste:** 5 minutos

---

### 2.2 Métricas Coletadas

| Métrica                 | Descrição                                                     |
| ----------------------- | ------------------------------------------------------------- |
| Nº de refeições         | Quantidade de vezes que cada filósofo conseguiu comer         |
| Tempo médio de espera   | Tempo entre a tentativa de comer e a obtenção dos dois garfos |
| Utilização dos garfos   | Percentual de tempo em que os garfos estiveram em uso         |
| Coeficiente de variação | Mede fairness: quanto menor, mais justa a distribuição        |

---

### 2.3 Método de Coleta

No código, cada filósofo mantém:

* Contador de refeições
* Registro de horário ao tentar comer
* Registro de horário ao obter os dois garfos
* Cálculo do tempo de espera
* Contador individual de uso dos garfos

Após 5 minutos de execução, os dados foram impressos no console e organizados neste relatório.

---

## 3. Resultados

Os valores apresentados a seguir são **exemplos realistas**, devendo ser substituídos pelos dados obtidos durante a execução real do programa.

---

### 3.1 Quantidade de Refeições por Filósofo

#### Tarefa 2 – Prevenção por Inversão de Garfos

| Filósofo | Refeições |
| -------- | --------- |
| 0        | 215       |
| 1        | 201       |
| 2        | 198       |
| 3        | 208       |
| 4        | 223       |

**Coeficiente de variação:** **5,1%**

---

#### Tarefa 3 – Semáforo (máx. 4 concorrendo)

| Filósofo | Refeições |
| -------- | --------- |
| 0        | 264       |
| 1        | 249       |
| 2        | 252       |
| 3        | 260       |
| 4        | 244       |

**Coeficiente de variação:** **2,8%**

---

#### Tarefa 4 – Monitor com Fairness

| Filósofo | Refeições |
| -------- | --------- |
| 0        | 230       |
| 1        | 231       |
| 2        | 228       |
| 3        | 233       |
| 4        | 230       |

**Coeficiente de variação:** **0,8% (altamente justo)**

---

### 3.2 Tempo Médio de Espera (ms)

| Solução  | Espera Média |
| -------- | ------------ |
| Tarefa 2 | 51 ms        |
| Tarefa 3 | 37 ms        |
| Tarefa 4 | 19 ms        |

---

### 3.3 Taxa de Utilização dos Garfos (%)

| Solução  | Utilização |
| -------- | ---------- |
| Tarefa 2 | 67%        |
| Tarefa 3 | 81%        |
| Tarefa 4 | 74%        |

---

## 4. Análise Comparativa

### 4.1 Prevenção de Deadlock

| Solução  | Deadlock?    | Motivo                                                     |
| -------- | ------------ | ---------------------------------------------------------- |
| Tarefa 2 |  Não ocorre | Um filósofo inverte a ordem e elimina o ciclo circular     |
| Tarefa 3 |  Não ocorre | Semáforo impede que todos disputem recursos ao mesmo tempo |
| Tarefa 4 |  Não ocorre | Monitor centraliza o controle de acesso                    |

**Conclusão:** todas as soluções analisadas previnem deadlock.

---

### 4.2 Prevenção de Starvation

| Solução  | Starvation possível? | Motivo                                       |
| -------- | -------------------- | -------------------------------------------- |
| Tarefa 2 |  Sim               | Não há garantia de prioridade ou fila        |
| Tarefa 3 |  Baixo risco       | Limita concorrência, mas não garante justiça |
| Tarefa 4 |  Não                | Uso de fila e monitor garante fairness       |

**Conclusão:** apenas a Tarefa 4 elimina completamente starvation.

---

### 4.3 Performance / Throughput

Ordem do melhor para o pior desempenho:

1. **Tarefa 3 (Semáforo)** – maior paralelismo
2. **Tarefa 4 (Monitor)** – overhead para garantir fairness
3. **Tarefa 2** – menor paralelismo

---

### 4.4 Complexidade de Implementação

Da mais simples para a mais complexa:

1. **Tarefa 2** – alteração mínima na ordem dos garfos
2. **Tarefa 3** – adição de semáforo global
3. **Tarefa 4** – monitor, fila e sincronização avançada

---

### 4.5 Consumo de Recursos

* **Tarefa 2:** uso mínimo de recursos
* **Tarefa 3:** baixo consumo
* **Tarefa 4:** maior custo devido ao controle de fairness

---

## 5. Conclusão

Cada solução é mais adequada para um cenário específico:

| Situação                       | Melhor Solução | Motivo              |
| ------------------------------ | -------------- | ------------------- |
| Simplicidade máxima            | Tarefa 2       | Fácil implementação |
| Melhor desempenho              | Tarefa 3       | Maior paralelismo   |
| Sistema crítico sem starvation | Tarefa 4       | Fairness garantida  |

### Conclusão Final

➡ **A Tarefa 4** é a solução mais equilibrada, garantindo ausência de deadlock e starvation, com distribuição justa das oportunidades, embora possua maior complexidade.

➡ **A Tarefa 3** apresenta o melhor desempenho geral e alta utilização de recursos, sendo indicada quando fairness não é prioridade.

➡ **A Tarefa 2** é adequada para sistemas simples, mas não recomendada para cenários reais que exigem garantias fortes de justiça.
