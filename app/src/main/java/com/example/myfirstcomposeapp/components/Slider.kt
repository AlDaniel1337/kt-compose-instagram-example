package com.example.myfirstcomposeapp.components

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BasicSlier(){
    var sliderPositionBs by rememberSaveable { mutableStateOf(0f) }
    var sliderPositionAd by rememberSaveable { mutableStateOf(0f) }
    var completeValue    by rememberSaveable { mutableStateOf("") }

    Column( modifier = Modifier.padding( horizontal = 16.dp ), horizontalAlignment = Alignment.CenterHorizontally ) {
        // Basico
        Slider( value = sliderPositionBs, onValueChange = { sliderPositionBs = it } )
        Text( text = sliderPositionBs.toString() )

        // Avanzado
        Slider(
            value = sliderPositionAd,
            onValueChange = { sliderPositionAd = it },
            valueRange = 0f..10f
        )
        Text( text = sliderPositionAd.toString() )

        Slider(
            value = sliderPositionAd,
            onValueChange = { sliderPositionAd = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text( text = sliderPositionAd.toString() )

        Slider(
            value = sliderPositionAd,
            onValueChange = { sliderPositionAd = it },
            onValueChangeFinished = { completeValue = sliderPositionAd.toString() },
            valueRange = 0f..10f,
            steps = 9
        )
        Text( text = completeValue )

        MyRangeSlider()
    }
}

//======[ RANGE SLIDER ]=====\\
@Composable
fun MyRangeSlider(){
    var raSliderPosition by remember { mutableStateOf(0f..10f) }
    RangeSlider(
        value = raSliderPosition,
        onValueChange = { raSliderPosition = it },
        valueRange = 0f..40f
    )

    Text( text = raSliderPosition.toString() )
    Text( text = "Valor Inferior: ${raSliderPosition.start}" )
    Text( text = "Valor Superior: ${raSliderPosition.endInclusive}" )

}