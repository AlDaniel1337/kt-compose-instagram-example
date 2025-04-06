package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ButtonHolder(){
    MyButtons( modifier = Modifier.fillMaxSize() )
}

@Composable
fun MyButtons( modifier: Modifier = Modifier ){
    Column( modifier = modifier ) {

        // Util en todos lo casos
        Button(
            onClick = { Log.i("boton", "Botón pulsado") },
            // Borde
            shape = RoundedCornerShape( 20 ),
            border = BorderStroke( 3.dp, Color.Blue ),

            // Colores
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Gray
            )
        ) {
            Text(text = "Pulsame")
        }

        // Útil en casos de baja importancia
        OutlinedButton(
            onClick = { Log.i("boton", "Botón pulsado") },
            // Colores
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red,
                containerColor = Color.Gray
            )
        ) {
            Text(text = "Pulsame")
        }

        // Útil para cosas poco importantes
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Green
            )
        ) {
            Text(text = "Pulsame")
        }
        
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Pulsame")
        }

    }
}