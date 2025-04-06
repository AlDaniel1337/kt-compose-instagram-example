package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Preview
@Composable
fun MySwitch(){
    Column( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        var state by rememberSaveable { mutableStateOf(false) }

        Switch(checked = state, onCheckedChange = { state = !state })
        Switch(checked = state, onCheckedChange = { state = !state }, enabled = false)

        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                uncheckedThumbColor = Color.Green,

                checkedTrackColor = Color.Green,
                uncheckedTrackColor = Color.Gray,
            )
        )

    }
}