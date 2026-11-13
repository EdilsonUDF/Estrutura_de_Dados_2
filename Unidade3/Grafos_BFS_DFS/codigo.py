Nome: Edilson Filho

#deque: implementa fila eficiente para BFS;
from collections import deque
import matplotlib.pyplot as plt
import networkx as nx

# Definindo dicionário de grafo
grafo = {
    "Brasília": ["Goiânia", "Belo Horizonte"],
    "Goiânia": ["Brasília", "São Paulo", "Cuiabá"],
    "Belo Horizonte": ["Brasília", "Rio de Janeiro"],
    "São Paulo": ["Goiânia", "Curitiba", "Rio de Janeiro"],
    "Cuiabá": ["Goiânia", "Curitiba"],
    "Rio de Janeiro": ["Belo Horizonte", "São Paulo", "Curitiba"],
    "Curitiba": ["São Paulo", "Cuiabá", "Rio de Janeiro"]
}

# 2. Desenhe um grafo com pelo menos sete vértices e conexões justificadas.---------------------------
G = nx.Graph(grafo)

# Tamanho da imagem gerada
plt.figure(figsize=(9, 7))

# Definindo um layout automático para distribuir os nós de forma organizada
# O 'seed' garante que a posição das cidades seja sempre a mesma ao rodar de novo
pos = nx.spring_layout(G, seed=42)
# Desenhando os nós, arestas e rótulos
nx.draw(
    G,
    pos,
    with_labels=True,
    node_color="lightblue",
    node_size=3200,
    font_size=10,
    font_weight="bold",
    edge_color="gray",
    width=2,
)

# Adicionando um título e exibindo o gráfico
plt.title("Visualização do Grafo de Cidades", fontsize=14)
plt.axis("off")  # Remove os eixos numéricos ao redor
plt.show()

print()
print()
#2------------------------------------------------------------------------------------------------------

#3. Implemente a lista de adjacência e BFS e DFS em Python----------------------------------------------
def bfs(rede, origem, destino):
    fila = deque([(origem, [origem])])

    visitados = {origem}
    while fila:
      #popleft() remove o primeiro elemento.
        atual, caminho = fila.popleft()
        if atual == destino:
            return caminho
        #visitados: evita revisitar vértices em uma rede com ciclos
        for vizinho in rede.get(atual, []):
            if vizinho not in visitados:
                visitados.add(vizinho)
                fila.append((vizinho, caminho + [vizinho]))
    return None

def dfs(rede, origem, destino):
    pilha = [(origem, [origem])]
    visitados = set()
    while pilha:
        atual, caminho = pilha.pop()
        if atual in visitados:
            continue
        visitados.add(atual)
        if atual == destino:
            return caminho
        for vizinho in reversed(rede.get(atual, [])):
            if vizinho not in visitados:
                pilha.append((vizinho, caminho + [vizinho]))
    return None

#3------------------------------------------------------------------------------------------------------
#5. Simule o bloqueio de pelo menos uma aresta, sem alterar permanentemente a rede original.------------
def bloquear_conexao(rede, a, b):
    copia = {no: vizinhos.copy() for no, vizinhos in rede.items()}
    if b in copia.get(a, []):
        copia[a].remove(b)
    if a in copia.get(b, []):
        copia[b].remove(a)
    return copia

#5------------------------------------------------------------------------------------------------------

# 4. Permita que o usuário informe origem e destino, validando nomes inexistentes---------------------
print()
# Solicita ao usuário digitar a origem e o destino de forma dinâmica
origem = input("Qual a origem? ")
destino = input("Qual o seu destino? ")

if origem in grafo and destino in grafo:
    print("\nO nome digitado existe!")
    print("Voce quer ir de " + origem + " para " + destino)

#4------------------------------------------------------------------------------------------------------

    for nome, rede in [("Normal", grafo), ("Bloqueio Goiânia–São Paulo", bloquear_conexao(grafo, "Goiânia", "São Paulo"))]:
        print("\nCenário:", nome)

        # Mantemos o grafo completo para desenho para não sumir com a aresta bloqueada
        G_cenario = nx.Graph(grafo)
        plt.figure(figsize=(9, 7))

        # Desenha nós e rótulos
        nx.draw_networkx_nodes(G_cenario, pos, node_color="lightblue", node_size=3200)
        nx.draw_networkx_labels(G_cenario, pos, font_size=10, font_weight="bold")

        # Identifica as arestas normais e a aresta bloqueada para estilizar diferentemente
        if "Bloqueio" in nome:
            # Arestas normais continuam cinzas
            arestas_normais = [e for e in G_cenario.edges() if not (e == ("Goiânia", "São Paulo") or e == ("São Paulo", "Goiânia"))]
            # Aresta bloqueada é marcada
            aresta_bloqueada = [e for e in G_cenario.edges() if (e == ("Goiânia", "São Paulo") or e == ("São Paulo", "Goiânia"))]

            nx.draw_networkx_edges(G_cenario, pos, edgelist=arestas_normais, edge_color="gray", width=2)
            nx.draw_networkx_edges(G_cenario, pos, edgelist=aresta_bloqueada, edge_color="red", style="dashed", width=3)
        else:
            nx.draw_networkx_edges(G_cenario, pos, edge_color="gray", width=2)

        plt.title(f"Visualização do Grafo de Cidades - {nome}", fontsize=14)
        plt.axis("off")
        plt.show()

        caminho_bfs = bfs(rede, origem, destino)
        caminho_dfs = dfs(rede, origem, destino)
#6. Mostre os caminhos retornados e a quantidade de arestas. Trate corretamente casos sem caminho.
        if caminho_bfs:
            print(f"BFS: {caminho_bfs} \n(Quantidade de arestas: {len(caminho_bfs) - 1})")
        else:
            print("BFS: Caminho não encontrado")

        if caminho_dfs:
            print(f"DFS: {caminho_dfs} \n(Quantidade de arestas: {len(caminho_dfs) - 1})")
        else:
            print("DFS: Caminho não encontrado")

#6------------------------------------------------------------------------------------------------------
else:
    print("\n[ERRO] Uma ou ambas as cidades digitadas não existem no grafo.")
    print(f"Você digitou: Origem = '{origem}' | Destino = '{destino}'")
    print("Cidades disponíveis:", list(grafo.keys()))

#8. Apresente sua implementação funcionando, com os testes executados.