package riqinho.com.github.fundamentosjetpackcompose.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ExercicioEstado(modifier: Modifier = Modifier){
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = name,
            onValueChange = {
                valorDigitado: String -> name = valorDigitado;
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") },
        )
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(
            value = lastName,
            onValueChange = {
                valorDigitado: String -> lastName = valorDigitado;
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Sobrenome") },
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(
            enabled = name.isNotBlank() && lastName.isNotBlank() ,
            onClick = {
                showMessage = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }
        Spacer(modifier = modifier.height(50.dp))
        if (showMessage){
            Text("Bem-vindo $name $lastName")
        }
    }

}
