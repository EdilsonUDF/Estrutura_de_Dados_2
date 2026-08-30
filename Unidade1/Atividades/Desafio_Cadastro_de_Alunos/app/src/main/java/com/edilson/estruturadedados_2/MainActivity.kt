package com.edilson.estruturadedados_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.edilson.estruturadedados_2.ui.model.Aluno
import com.edilson.estruturadedados_2.ui.theme.EstruturaDeDados_2Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstruturaDeDados_2Theme {
                Home()
            }
        }
    }
}


@PreviewScreenSizes
@Composable
fun Home() {

    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.HOME)
    }

    var alunos by remember {
        mutableStateOf(listOf<Aluno>())
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {

            AppDestinations.entries.forEach {

                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },

                    label = {
                        Text(it.label)
                    },

                    selected = it == currentDestination,

                    onClick = {
                        currentDestination = it
                    }
                )
            }
        }
    ) {

        when (currentDestination) {

            AppDestinations.HOME -> {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    CadastroAluno(
                        quantidadeAlunos = alunos.size,
                        onAlunoAdicionado = { aluno ->

                            if (alunos.size < 5) {

                                alunos = alunos + aluno

                            }
                        }
                    )

                    HorizontalDivider()

                }
            }

            AppDestinations.FAVORITES -> {
                CabecalhoTabela()


                LazyColumn(   modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)) {
                    items(alunos) { aluno ->

                        AlunoItem(aluno)

                        HorizontalDivider()
                    }
                }
            }

            AppDestinations.PROFILE -> {

                val alunoMaiorMedia = alunos.maxByOrNull { it.media }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(
                        text = "ALUNO COM A MAIOR MÉDIA",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.padding(10.dp)
                    )

                    if (alunoMaiorMedia != null) {

                        Text(
                            text = "Aluno: ${alunoMaiorMedia.name}",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Idade: ${alunoMaiorMedia.idade}"
                        )

                        Text(
                            text = "Média: %.1f".format(alunoMaiorMedia.media)
                        )

                    } else {

                        Text(
                            text = "Nenhum aluno cadastrado."
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CadastroAluno(
    quantidadeAlunos: Int,
    onAlunoAdicionado: (Aluno) -> Unit
) {

    val context = LocalContext.current

    var nome by remember {
        mutableStateOf("")
    }

    var idade by remember {
        mutableStateOf("")
    }

    var notas by remember {
        mutableStateOf(listOf("", "", ""))
    }

    val podeAdicionar =
        nome.isNotBlank() &&
                idade.toIntOrNull() != null &&
                notas.all { it.toFloatOrNull() != null } &&
                quantidadeAlunos < 5

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Cadastrar Aluno",
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = nome,
                onValueChange = {
                    nome = it
                },
                label = {
                    Text("Nome")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = idade,
                onValueChange = {
                    idade = it
                },
                label = {
                    Text("Idade")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = notas[0],
                onValueChange = { valor ->

                    notas = notas.toMutableList().apply {
                        this[0] = valor
                    }
                },
                label = {
                    Text("Nota 1")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = notas[1],
                onValueChange = { valor ->

                    notas = notas.toMutableList().apply {
                        this[1] = valor
                    }
                },
                label = {
                    Text("Nota 2")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = notas[2],
                onValueChange = { valor ->

                    notas = notas.toMutableList().apply {
                        this[2] = valor
                    }
                },
                label = {
                    Text("Nota 3")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {

                    val idadeInt = idade.toIntOrNull()

                    val notasFloat = notas.mapNotNull {
                        it.toFloatOrNull()
                    }

                    if (
                        nome.isNotBlank() &&
                        idadeInt != null &&
                        notasFloat.size == 3 &&
                        quantidadeAlunos < 5
                    ) {

                        val media = notasFloat.average().toFloat()

                        val aluno = Aluno(
                            name = nome,
                            idade = idadeInt,
                            notas = notasFloat.toTypedArray(),
                            media = media
                        )

                        onAlunoAdicionado(aluno)

                        Toast.makeText(
                            context,
                            "Aluno adicionado com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()

                        nome = ""
                        idade = ""
                        notas = listOf("", "", "")
                    }
                },

                enabled = podeAdicionar,

                colors = ButtonDefaults.buttonColors(
                    containerColor = if (podeAdicionar) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Gray
                    }
                ),

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Adicionar aluno")
            }

            Text(
                text = "Alunos cadastrados: $quantidadeAlunos / 5"
            )
        }
    }
}


fun calcularMedia(aluno: Aluno): Float {

    return aluno.notas
        .toList()
        .average()
        .toFloat()
}


@Composable
fun CabecalhoTabela() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {

        Text(
            text = "Nome",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )

        Text(
            text = "Idade",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )

        Text(
            text = "Notas",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )

        Text(
            text = "Média",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )
    }
}


@Composable
fun AlunoItem(aluno: Aluno) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        // Nome
        Text(
            text = aluno.name,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )

        // Idade
        Text(
            text = aluno.idade.toString(),
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )

        // Notas
        Column(
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        ) {

            aluno.notas.forEachIndexed { index, nota ->
                Text(
                    text = "%.1f".format(nota)
                )
            }
        }

        // Média
        Text(
            text = "%.1f".format(aluno.media),
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
        )
    }
}


enum class AppDestinations(
    val label: String,
    val icon: ImageVector
) {

    HOME(
        "Alunos",
        Icons.Default.AddCircle
    ),

    FAVORITES(
        "Boletim",
        Icons.Default.AccountBox
    ),

    PROFILE(
        "Profile",
        Icons.Default.Favorite
    )
}


//@Composable
//fun Greeting(
//    name: String,
//    modifier: Modifier = Modifier
//) {
//
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//    EstruturaDeDados_2Theme {
//        Greeting("Android")
//    }
//}