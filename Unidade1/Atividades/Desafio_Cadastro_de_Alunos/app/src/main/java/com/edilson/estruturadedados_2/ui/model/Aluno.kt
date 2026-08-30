package com.edilson.estruturadedados_2.ui.model

//1. Crie uma `struct Aluno`.
//2. A struct deve possuir:
//
//* nome;
//* idade;
//* três notas.
data class Aluno(
    val name: String,
    val idade: Int,
    val notas: Array<Float>,
    val media: Float
){
    init {
        require(name.length <= 50) {
            "O nome deve ter no máximo 50 caracteres"
        }

        require(notas.size == 3) {
            "O aluno deve possuir exatamente 3 notas"
        }
    }
}
