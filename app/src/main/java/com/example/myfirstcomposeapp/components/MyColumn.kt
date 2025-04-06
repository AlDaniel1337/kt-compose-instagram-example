package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MyColumn( modifier: Modifier ){
    Column( modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .weight(1f) ){
            Text(text = "Ejemplo1")
        }

        Row(modifier = Modifier
            .weight( 1f )
            .fillMaxSize())
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .weight(1f) )
            {
                Text(text = "Ejemplo2")
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
                .weight(1f) )
            {
                Text(text = "Ejemplo3")
            }
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .weight(1f) )
        {
            Text(text = "Ejemplo4")
        }
    }
}