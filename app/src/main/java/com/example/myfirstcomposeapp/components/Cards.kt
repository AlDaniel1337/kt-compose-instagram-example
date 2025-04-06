package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation( 12.dp ),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = Color.White
        ),
        border = BorderStroke( 2.dp, Color.Black)
    ) {
        Column( modifier = Modifier.padding( 16.dp )) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Preview
@Composable
fun MySurface(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke( 2.dp, Color.Black)
    ) {
        Column( modifier = Modifier.padding( 16.dp )) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}