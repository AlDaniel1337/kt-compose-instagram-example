package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Preview
@Composable
fun MyProgressBar(){

    var showLoading by rememberSaveable { mutableStateOf(false) }
    var progress by rememberSaveable { mutableStateOf(0.0f) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if( showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)
            LinearProgressIndicator(modifier = Modifier.padding(top = 16.dp), color = Color.Red,)
            CircularProgressIndicator(
                progress = progress,
                color = Color.Blue,
                strokeWidth = 8.dp,
                modifier = Modifier.padding( top = 16.dp )
            )

            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                Button(
                    onClick = {
                        progress -= 0.1f
                        if (progress <= 0.0f) progress = 0.0f
                    },
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(text = "Menos")
                }

                Button(
                    onClick = {
                        if (progress >= 1.0f) progress = 0.0f
                        progress += 0.1f
                    },
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(text = "Más")
                }
            }
        }

        Button(onClick = { showLoading = !showLoading }, modifier = Modifier.padding(top = 24.dp)) {
            Text(text = if (showLoading) "Ocultar" else "Mostrar")
        }
    }
}