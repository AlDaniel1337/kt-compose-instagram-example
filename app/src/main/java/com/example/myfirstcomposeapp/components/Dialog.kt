package com.example.myfirstcomposeapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import com.example.myfirstcomposeapp.R

@Preview
@Composable
fun MyState( modifier: Modifier = Modifier ){
    var showAlertDialog by rememberSaveable { mutableStateOf(false) }
    var showSimpleCustomDialog by rememberSaveable { mutableStateOf(false) }
    var showCustomDialog by rememberSaveable { mutableStateOf(false) }
    var showConfirmationDialog by rememberSaveable { mutableStateOf(false) }



    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAlertDialog(
            show = showAlertDialog,
            onConfirm = { showAlertDialog = false },
            onDissmiss = { showAlertDialog = false }
        )
        Button(onClick = { showAlertDialog = true }) {
            Text(text = "Mostrar Alert Dialog")
        }

        MySimpleCustomDialog(
            show = showSimpleCustomDialog,
            onConfirm = { showSimpleCustomDialog = false },
            onDismiss = { showSimpleCustomDialog = false }
        )
        Button(onClick = { showSimpleCustomDialog = true }) {
            Text(text = "Mostrar Simple Custom Dialog")
        }

        MyCustomDialog(
            show = showCustomDialog,
            onConfirm = { showCustomDialog = false },
            onDismiss = { showCustomDialog = false }
        )
        Button(onClick = { showCustomDialog = true }) {
            Text(text = "Mostrar Custom Dialog")
        }

        MyConfirmationDialog(
            show = showConfirmationDialog,
            onDismiss = { showConfirmationDialog = false }
        )
        Button(onClick = { showConfirmationDialog = true }) {
            Text(text = "Mostrar Confirmation Dialog")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlertDialog(
    show: Boolean,
    onDissmiss:()->Unit,
    onConfirm:()->Unit,
){
    if(show) {
        AlertDialog(onDismissRequest = { /*TODO*/ }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(12.dp),
                shape = MaterialTheme.shapes.large,
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Titulo", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Hola mundo")

                    Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                        Button(onClick = { onConfirm() }) { Text(text = "Confirm") }
                        Button(onClick = { onDissmiss() }) { Text(text = "Dismiss") }
                    }
                }
            }
        }
    }
}


@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss:()->Unit,
    onConfirm:()->Unit,
){
    if(show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(12.dp),
                shape = MaterialTheme.shapes.large,
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Titulo", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Hola mundo")

                    Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                        Button(onClick = { onConfirm() }) { Text(text = "Confirm") }
                        Button(onClick = { onDismiss() }) { Text(text = "Dismiss") }
                    }
                }
            }
        }
    }
}



//=====[ CONFIRMATION DIALOG ]=====\\
@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
){
    if(show){
        Dialog(onDismissRequest = { onDismiss() }) {
           Box( modifier = Modifier.clip(RoundedCornerShape(50f)) ){
               Column( modifier = Modifier
                   .fillMaxWidth()
                   .background(Color.White)
                   .padding(8.dp)
               ){
                   MyCustomDialogTitle(text= "Phone ringtone", modifier = Modifier.padding(24.dp))
                   Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)

                   //~ ARCHIVO: components/Checks
                   MyRadioButton()

                   Divider()
                   Row( modifier = Modifier.align( Alignment.End).padding( 8.dp ) ) {
                       TextButton(onClick = {}) { Text(text = "CANCEL") }
                       TextButton(onClick = {}) { Text(text = "OK") }
                   }
               }
           }
        }
    }
}


//=====[ ACCOUNT EXAMPLE ]=====\\
@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss:()->Unit,
    onConfirm:()->Unit,
){
    if(show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(12.dp),
                shape = MaterialTheme.shapes.large,
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    MyCustomDialogTitle(text = "Set backup account")

                    AccountItem(email = "ejemplo1@gmail.com", drawable = R.drawable.avatar)
                    AccountItem(email = "ejemplo2@gmail.com", drawable = R.drawable.avatar)
                    AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)

                    Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                        Button(onClick = { onConfirm() }) { Text(text = "Confirm") }
                        Button(onClick = { onDismiss() }) { Text(text = "Dismiss") }
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialogTitle( text:String, modifier: Modifier = Modifier.padding(bottom = 12.dp) ) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}


// Imagen circular con texto
@Composable
fun AccountItem(
    email: String,
    @DrawableRes drawable: Int
){
    Row( verticalAlignment = Alignment.CenterVertically ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier =  Modifier.padding(8.dp)
        )
    }
}