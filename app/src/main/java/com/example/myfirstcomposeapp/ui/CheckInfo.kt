package com.example.myfirstcomposeapp.ui

// Basicamente es una interface
data class CheckInfo(
    val title:String,
    var selected:Boolean = false,
    var onCheckedChange:(Boolean) -> Unit
)