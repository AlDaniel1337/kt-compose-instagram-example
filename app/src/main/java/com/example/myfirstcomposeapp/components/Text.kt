package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyText() {
    Column {
        Text(text = "Hola mundo")
        Text(text = "Hola mundo", color = Color.Red)
        Text(text = "Hola mundo", fontSize = 24.sp)
        Text(text = "Hola mundo", fontStyle = FontStyle.Italic)
        Text(text = "Hola mundo", fontWeight = FontWeight.Bold)
        Text(
            text = "Hola mundo",
            color = Color.Red,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Hola mundo", letterSpacing = 20.sp)
        Text(text = "Hola mundo", textDecoration = TextDecoration.Underline)
        Text(text = "Hola mundo", textAlign = TextAlign.Center, fontSize = 24.sp, modifier = Modifier.fillMaxSize())
    }
}



//=====[ TextField ]=====\\
@Preview
@Composable
fun MyTextField( modifier: Modifier = Modifier ) {
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(value = text, onValueChange = { text = it })
    }
}

@Preview
@Composable
fun MyForm( modifier: Modifier = Modifier ) {
    var password by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        PasswordField( password = password){ password = it }
    }
}

@Composable
fun PasswordField( modifier: Modifier = Modifier, password:String, onUserChange:( String )->Unit ) {

    var hiddenPassword by remember { mutableStateOf(true) }

    Column(modifier = modifier) {
        TextField(value = password, onValueChange = { onUserChange(it) })

        TextField(
            value = password,
            placeholder = { Box(modifier = Modifier.size(40.dp)) },
            label = { Text(text = "Nombre") },
            onValueChange = { onUserChange(it) }
        )

        /// Campo con configuración avanzada
        TextField(
            value = password,
            placeholder = { Box(modifier = Modifier.size(40.dp)) },
            label = { Text(text = "Nombre") },
            // Tipo de teclado
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
            // Mostrar o ocultar información
            visualTransformation =  if(hiddenPassword) PasswordVisualTransformation() else VisualTransformation.None,
            // Icono
            trailingIcon = { Text( text = if(hiddenPassword) "M" else "O", modifier = Modifier.clickable { hiddenPassword = !hiddenPassword } ) },
            onValueChange = {
                if(it.contains("a")) it.replace("a", "A")
                onUserChange(it)
            }
        )

        // Campo con configuración prefedinida
        OutlinedTextField(
            value = password,
            onValueChange = {
                if(it.contains("a")) it.replace("a", "A")
                onUserChange(it)
            }
        )

        // Campo sin ningún tipo de configuración
        BasicTextField(
            value = password,
            onValueChange = {
                if(it.contains("a")) it.replace("a", "A")
                onUserChange(it)
            }
        )
    }
}