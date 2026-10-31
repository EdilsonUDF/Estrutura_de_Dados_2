<img width="919" height="743" alt="image" src="https://github.com/user-attachments/assets/489cdabc-0944-4a89-a1f4-a7e41b9065f2" /># Material do Estudante — Grafos, BFS e DFS

**Disciplina:** Estrutura de Dados II — Ciência da Computação

**Professora:** Kadidja Valéria

**Estudo de caso:** pane relacionada ao GPS e impactos em voos no Aeroporto de Brasília (G1, 22 set. 2026)

**Aluno:** Edilson Filho

> **Importante:** esta atividade é uma simulação computacional, não um modelo de navegação aeronáutica operacional. A notícia motiva o problema; os bloqueios e rotas do exercício são fictícios.

## 1. Situação-problema e objetivo

Uma indisponibilidade de recursos de navegação pode provocar replanejamento operacional. Neste laboratório, representaremos conexões hipotéticas entre cidades como um grafo e procuraremos caminhos entre Brasília e Curitiba, comparando os algoritmos BFS e DFS. O objetivo não é indicar rotas de voo reais, mas estudar conectividade e algoritmos de busca.

**Sua missão:** projetar um grafo próprio com pelo menos sete vértices, implementar BFS e DFS em Python, simular a remoção de uma conexão e justificar a solução encontrada.

# Relatório de Modelagem e Análise de Grafos: Redes Logísticas

## 1. O Problema
O planejamento logístico e de transportes exige encontrar rotas eficientes e garantir rotas alternativas no caso de interrupções físicas de vias, tais como obras, acidentes ou desastres naturais. O problema consiste em mapear as interconexões rodoviárias entre 7 cidades do Brasil, buscar caminhos válidos de uma origem para um destino e analisar dinamicamente como o bloqueio estratégico da rodovia entre Goiânia e São Paulo afeta os trajetos gerados.

---

## 2. O Objetivo
* **Modelagem de Redes:** Representar conexões terrestres reais de maneira abstrata como um grafo não direcionado utilizando listas de adjacência.
* **Comparação de Algoritmos:** Aplicar e contrapor os comportamentos dos algoritmos **Busca em Largura (BFS)** (que garante o menor número de arestas) e **Busca em Profundidade (DFS)**.
* **Simulação Dinâmica:** Avaliar em tempo real o impacto do bloqueio da aresta Goiânia-São Paulo na conectividade geral e no comprimento dos caminhos alternativos.
* **Visualização Gráfica:** Renderizar de forma visual e intuitiva o status das conexões, colorindo ou destacando de forma tracejada as vias obstruídas.

---

## 3. Instruções de Uso
1. Execute a célula de código do sistema.
2. Uma primeira visualização do grafo de referência estático será exibida.
3. O console solicitará duas entradas dinâmicas de texto:
   * **Qual a origem?** (Exemplo: `Brasília`)
   * **Qual o seu destino?** (Exemplo: `Cuiabá`)
4. O sistema verificará se ambas as cidades existem no mapa. Se sim, gerará a visualização gráfica e os resultados em texto para dois cenários distintos:
   * **Cenário Normal:** A rede original com todas as estradas livres.
   * **Cenário de Bloqueio:** A estrada entre Goiânia e São Paulo fica obstruída (sinalizada em vermelho e tracejada no mapa). O algoritmo recalculará as rotas sem utilizá-la.

---

## 4. Estrutura do Grafo
O grafo de conexões implementado é **não direcionado** e conta com **7 vértices (cidades)** e **10 arestas (conexões)**:

* **Vértices:** Brasília, Goiânia, Belo Horizonte, São Paulo, Cuiabá, Rio de Janeiro, Curitiba.
* **Justificativa de Conectividade:**
  * **Brasília** se conecta diretamente com a capital vizinha Goiânia e com o principal acesso à região sudeste por Belo Horizonte.
  * **Cuiabá** serve de conexão centro-oeste para o sul através de Curitiba.
  * **Rio de Janeiro** e **São Paulo** concentram as conexões de alta capacidade conectando-se entre si, com Belo Horizonte e Curitiba.

---

## 5. Resultados Esperados
* **BFS (Breadth-First Search):** Retorna sempre o caminho ótimo em termos de quantidade de saltos (arestas). Por exemplo, de Brasília para Cuiabá sob condições normais, o caminho gerado é `['Brasília', 'Goiânia', 'Cuiabá']` (2 arestas).
* **DFS (Depth-First Search):** Explora os caminhos até a profundidade máxima antes do *backtracking*, podendo retornar caminhos mais longos e redundantes dependendo da ordem dos nós na lista de adjacência, como `['Brasília', 'Goiânia', 'São Paulo', 'Curitiba', 'Cuiabá']` (4 arestas).
* **Comportamento sob Bloqueio:** Ao interromper a via principal Goiânia-São Paulo, o sistema força a busca de rotas alternativas (desviando, por exemplo, por Cuiabá-Curitiba ou via Belo Horizonte-Rio de Janeiro), evidenciando a tolerância a falhas da rede geográfica projetada.

## 6. Diagrama do grafo e evidências dos testes.

## 7. Questões para reflexão


**1. Por que um grafo representa melhor a rede do que uma árvore binária?**
Uma árvore binária tem hierarquia (raiz, pais e filhos), no máximo dois filhos por nó e exatamente um caminho entre dois nós. A rede tem ciclos (ex.: BSB – GYN – GRU – BHZ – BSB), vértices com 5 vizinhos e vários caminhos entre o mesmo par. São justamente os caminhos alternativos que permitem contornar um bloqueio, e uma árvore não os comporta.

**2. Em qual condição BFS encontra o menor caminho? O que significa “menor”?**
Quando o grafo é **não ponderado** (ou todas as arestas têm o mesmo peso). “Menor” significa **menor número de arestas**, não menor distância ou tempo. Isso vale porque o BFS visita os vértices em ordem crescente de distância em arestas: o primeiro momento em que o destino sai da fila é pelo nível mais baixo possível.

**3. Por que DFS pode retornar um caminho diferente de BFS?**
Porque o DFS segue o primeiro ramo disponível até o fim e retorna o primeiro caminho que alcança o destino, sem comparar com outros. No Experimento B ele entrou por CGR e achou um caminho de 5 arestas, enquanto existia um de 3. A ordem dos vizinhos determina qual ramo é explorado primeiro (Experimento D).

**4. O que ocorre sem um conjunto de visitados?**
Em um grafo com ciclos, os algoritmos voltariam a vértices já processados indefinidamente. Exemplo: BSB → GYN → BSB → GYN… O DFS entraria em laço infinito e o BFS encheria a fila com repetições, consumindo memória exponencialmente sem terminar quando não há caminho.

**5. Que informações seriam necessárias para avaliar tempo ou custo?**
Pesos nas arestas (distância, tempo de voo, custo, consumo), sentido das conexões, horários e frequências, capacidade, tempo de conexão nos vértices, condições meteorológicas e restrições operacionais. Com pesos, usar-se-ia Dijkstra ou A* em vez de BFS.

**6. Por que o resultado não pode orientar um voo real?**
O modelo é fictício e simplificado: ignora espaço aéreo, procedimentos de navegação, autorizações de controle de tráfego, meteorologia, combustível, desempenho da aeronave e redundâncias reais de navegação. Ele estuda **conectividade** em uma estrutura de dados, não navegação aeronáutica.

