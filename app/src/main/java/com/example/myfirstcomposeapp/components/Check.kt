package com.example.myfirstcomposeapp.components

import android.widget.CheckBox
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.CheckInfo


@Preview
@Composable
fun CheckBoxScreen(){

    var state by rememberSaveable { mutableStateOf(false) }
    val checkInfo = CheckInfo(
        title = "ejemplo1",
        selected = state,
        onCheckedChange = { newStatus -> state = newStatus }
    )

    // Listado con la configuración para los checkbox
    val myOptions = getOptions(titles = listOf("A", "B", "C"))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        MyCheckBox(state){ state = !state }
        MyCheckBoxText(state){ state = !state }

        MyCheckBoxTextCompleted(checkInfo)

        // Generar multiples instancias
        myOptions.forEach{
            MyCheckBoxTextCompleted(it)
        }

        // Tri-state
        MyTriStatusCheckBox()

        MyRadioButton()
    }

}

@Composable
fun MyCheckBox( state:Boolean, onChange:()->Unit ){
    Checkbox(
        checked = state,
        onCheckedChange = { onChange() },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            checkmarkColor = Color.Black
        )
    )
}

@Composable
fun MyCheckBoxText( state:Boolean, onChange:()->Unit ){
    Row( modifier = Modifier.padding( 8.dp ), verticalAlignment = Alignment.CenterVertically ) {
        Checkbox(
            checked = state,
            onCheckedChange = { onChange() },
        )
        Spacer(modifier = Modifier.width( 2.dp ))
        Text(text = "Hola mundo")
    }
}

@Composable
fun MyCheckBoxTextCompleted( checkInfo: CheckInfo ){
    Row( modifier = Modifier.padding( 8.dp ), verticalAlignment = Alignment.CenterVertically ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange( !checkInfo.selected ) },
        )
        Spacer(modifier = Modifier.width( 2.dp ))
        Text(text = checkInfo.title)
    }
}



//=====[ CHECKBOX INDETERMINADO ]=====\\
@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off ) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On            -> ToggleableState.Off
            ToggleableState.Off           -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}



// ANCHOR =====[ RADIO BUTTON ]=====\\
@Composable
fun MyRadioButton(){
    var status by rememberSaveable { mutableStateOf("A") }
    val options = listOf("A", "B", "C", "D")

    Column( Modifier.fillMaxWidth() ) {
        options.map { op ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                RadioButton(
                    selected = status == op,
                    onClick = { status = op },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Yellow,
                        disabledSelectedColor = Color.Gray
                    )
                )
                Text( text = op)
            }
        }
    }
}





/// Crear listado para multiples checkbox
@Composable
fun getOptions( titles: List<String>):List<CheckInfo> {
    return titles.map { title ->
        // Estado para la nueva instancia
        var state by rememberSaveable { mutableStateOf(false) }
        // Nueva instancia
        CheckInfo(
            title = title,
            selected = state,
            onCheckedChange = { newStatus -> state = newStatus }
        )
    }
}