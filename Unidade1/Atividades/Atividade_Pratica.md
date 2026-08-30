# 7. Atividade Prática

## 📝 Desafio — Cadastro de Alunos

Crie um programa que:

1. Crie uma `struct Aluno`.
2. A struct deve possuir:

   * nome;
   * idade;
   * três notas.
3. Crie um array para armazenar cinco alunos.
4. Leia os dados dos cinco alunos.
5. Calcule a média de cada aluno.
6. Mostre o nome e a média de cada aluno.
7. Informe qual aluno possui a maior média.

### Estrutura sugerida

```c
struct Aluno {
    char nome[50];
    int idade;
    float notas[3];
};
```

Observe que temos uma combinação de estruturas:

```text
Struct Aluno
│
├── nome
├── idade
└── notas
    ├── nota 0
    ├── nota 1
    └── nota 2
```

Nesse exemplo temos:

* uma `struct`;
* um array dentro da `struct`;
* possibilidade de criar um array de `structs`.
