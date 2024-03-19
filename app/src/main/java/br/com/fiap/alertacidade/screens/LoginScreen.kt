package br.com.fiap.alertacidade.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.alertacidade.R

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003366))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocalImageExamplePreview()

        Text(
            text = "AlertaCidade",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(48.dp))

        TextField(
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(24.dp),
            onValueChange = { email = it },
            label = { Text("E-mail") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Ícone de envelope",
                    tint = Color(0xFF003366)
                )
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = password,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it },
            shape = RoundedCornerShape(24.dp),
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Ícone de cadeado",
                    tint = Color(0xFF003366)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("menu") },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.size(width = 200.dp, height = 50.dp)
        ) {
            Text(
                "Acessar",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Não tem uma conta?",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        PreviewClickableText()
    }
}

@Composable
fun ClickableTextExample() {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Yellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
            append("Cadastre-se")
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewClickableText() {
    ClickableTextExample()
}

@Composable
fun LocalImageExample() {
    Image(
        painter = painterResource(R.drawable.cidade),
        contentDescription = "Logo de Cidade Inteligente",
        modifier = Modifier
            .size(width = 64.dp, height = 64.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LocalImageExamplePreview() {
    LocalImageExample()
}
