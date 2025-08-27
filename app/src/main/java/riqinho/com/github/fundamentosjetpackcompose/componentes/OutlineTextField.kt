package riqinho.com.github.fundamentosjetpackcompose.componentes

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SimpleOutlineTextField(modifier: Modifier = Modifier){
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var isError1 by remember { mutableStateOf(false) }
    var focusRequester2 = remember { FocusRequester() }
    var isSecondFocused by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier,
            value = text1,
            onValueChange = { novoValorDigitado: String ->
                text1 = novoValorDigitado
                if (isSecondFocused) {
                    isError1 = novoValorDigitado.isEmpty()
                } else {
                    isError1 = false
                }
            },
            label = { Text(text = "Nome") },
            isError = isError1,
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .focusRequester(focusRequester2)
                .onFocusChanged { focusState ->
                    isSecondFocused = focusState.isFocused
                    if (focusState.isFocused) {
                        isError1 = text1.isEmpty()
                    }
                },
            value = text2,
            onValueChange = { novoValorDigitado: String ->
                text2 = novoValorDigitado
            },
            label = { Text(text = "Sobrenome") },
            singleLine = true,
        )
    }
}