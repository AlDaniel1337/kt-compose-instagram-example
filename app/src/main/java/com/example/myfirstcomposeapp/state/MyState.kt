package com.example.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState( modifier: Modifier = Modifier ){
    
    var num by rememberSaveable { mutableStateOf(0) }

    StateExample1(num){ num += 1 }
}

@Composable
fun StateExample1( num:Int, modifier: Modifier = Modifier, onClick:()->Unit ){
    Text(text = "Pulsame: $num", modifier = modifier.clickable { onClick() })
}