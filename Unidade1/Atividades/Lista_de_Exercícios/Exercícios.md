# 8. Lista de Exercícios — Revisão

## Exercício 1 — Soma de um vetor

Crie um programa que leia **10 números inteiros** e armazene-os em um array.

Ao final, apresente:

* todos os números;
* a soma dos elementos;
* a média dos valores.

---

## Exercício 2 — Maior e menor

Leia **10 números inteiros** utilizando um array.

Determine:

* o maior valor;
* o menor valor;
* as posições em que eles aparecem.

---

## Exercício 3 — Números pares

Leia **20 números inteiros** e armazene-os em um array.

Depois:

* mostre somente os números pares;
* conte quantos números pares existem;
* calcule a soma dos números pares.

---

## Exercício 4 — Inversão de vetor

Leia **10 números** e armazene-os em um array.

Mostre o vetor original e o vetor invertido.

### Exemplo

```text
Vetor original:
1 2 3 4 5 6 7 8 9 10

Vetor invertido:
10 9 8 7 6 5 4 3 2 1
```

**Desafio:** não utilize outro array para realizar a inversão.

---

## Exercício 5 — Matriz 3 × 3

Crie uma matriz `3 x 3` de números inteiros.

O programa deverá:

* ler os valores;
* mostrar a matriz;
* calcular a soma de todos os elementos;
* mostrar o maior valor.

---

## Exercício 6 — Diagonal principal

Leia uma matriz `4 x 4`.

Mostre os elementos da **diagonal principal** e calcule sua soma.

### Exemplo

```text
 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16
```

Diagonal principal:

```text
1 6 11 16
```

Soma:

```text
34
```

---

## Exercício 7 — Matriz de notas

Uma turma possui **4 alunos e 3 avaliações**.

Crie uma matriz para armazenar as notas:

```text
          P1   P2   P3
Aluno 1
Aluno 2
Aluno 3
Aluno 4
```

Calcule e apresente a média de cada aluno.

---

## Exercício 8 — Struct Produto

Crie uma `struct Produto` contendo:

```text
nome
codigo
preco
quantidade
```

Cadastre **cinco produtos**.

Depois:

* mostre todos os produtos;
* calcule o valor total de cada produto;
* informe o produto com maior valor em estoque.

### Fórmula

```text
valor em estoque = preço × quantidade
```

---

## Exercício 9 — Struct Aluno

Crie uma `struct Aluno` contendo:

```text
nome
idade
nota1
nota2
nota3
```

Cadastre **cinco alunos**.

Calcule a média de cada aluno e classifique:

```text
Média >= 7,0 → Aprovado
Média < 7,0  → Reprovado
```

Ao final, informe:

* quantidade de aprovados;
* quantidade de reprovados;
* aluno com maior média.

---

# Exercício 10 — Sistema Integrado

Crie um pequeno sistema para cadastro de **10 funcionários**.

Utilize uma `struct` contendo:

```text
nome
idade
cargo
salario
```

O programa deverá permitir:

1. Cadastrar os funcionários.
2. Listar todos os funcionários.
3. Mostrar o funcionário com maior salário.
4. Calcular a média salarial.
5. Mostrar os funcionários com salário acima da média.
