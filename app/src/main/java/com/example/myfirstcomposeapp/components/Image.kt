package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.myfirstcomposeapp.R

@Preview
@Composable
fun MyImage(){
    Column( modifier = Modifier.fillMaxSize() ) {

        // Imagen basica
        Image(
            // Imagen
            painter = painterResource(id = R.drawable.ic_launcher_background),
            // Descripción
            contentDescription = "Description",
            // Opacidad
            alpha = 0.5f
        )

        // Imagen avanzada
        Image(
            // Imagen
            painter = painterResource(id = R.drawable.ic_launcher_background),
            // Descripción
            contentDescription = "Description",
            // Opacidad
            alpha = 1f,
            // Bordes redondeados
            modifier = Modifier.clip( RoundedCornerShape(25f) )
        )
        Image(
            // Imagen
            painter = painterResource(id = R.drawable.ic_launcher_background),
            // Descripción
            contentDescription = "Description",
            // Opacidad
            alpha = 1f,
            // Bordes redondeados
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.LightGray, CircleShape)
        )

        // Icono
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "icono",
            tint = Color.Green
        )

    }
}