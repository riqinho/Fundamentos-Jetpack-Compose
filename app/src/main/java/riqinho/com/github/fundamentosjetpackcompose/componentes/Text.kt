package riqinho.com.github.fundamentosjetpackcompose.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import riqinho.com.github.fundamentosjetpackcompose.R
import java.nio.file.WatchEvent


@Composable
fun SimpleText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.hello_turma),
            color = Color.Blue,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TextShadow(){
    val offset = Offset(x = 5f, y = 10f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.hello_turma),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(color = Color.Blue, offset, blurRadius = 5f)
            )
        )
    }
}

@Composable
fun DifferentFont(){
    val fontFamilyEdu = FontFamily(
         Font(R.font.edu_nswact_cursive_regular, FontWeight.Normal),
         Font(R.font.edu_nswact_cursive_medium, FontWeight.Medium),
         Font(R.font.edu_nswact_cursive_semibold, FontWeight.SemiBold),
         Font(R.font.edu_nswact_cursive_bold, FontWeight.Bold),
    )

    Column {
        Text(text = stringResource(R.string.hello_turma), fontFamily = FontFamily.Serif)
        Text(text = stringResource(R.string.hello_turma), fontFamily = FontFamily.Monospace)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Edu NSWACT Cursive regular. Eu preciso colocar um texto gigante neste local!",
            fontFamily = fontFamilyEdu,
            fontWeight = FontWeight.Normal,
            maxLines = 1
        )
        Text(
            text = "Edu NSWACT Cursive medium. Eu preciso colocar outro texto gigante neste local!",
            fontFamily = fontFamilyEdu,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Edu NSWACT Cursive semibold",
            fontFamily = fontFamilyEdu,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Edu NSWACT Cursive bold",
            fontFamily = fontFamilyEdu,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun Preview() {
    DifferentFont()
}