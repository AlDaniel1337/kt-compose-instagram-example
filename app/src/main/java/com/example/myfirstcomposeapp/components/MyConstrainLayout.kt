package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun MyConstrainLayoutPreview(){
    MyConstrainLayout( Modifier.fillMaxSize() )
}

@Composable
fun MyConstrainLayout( modifier: Modifier ){
    ConstraintLayout( modifier = modifier ) {
        val smallSize = 75;
        val bigSize = 175;
        val (boxCyan, boxBlack, boxDarkGray, boxMagenta, boxGreen, boxYellow, boxGray, boxBlue, boxRed) = createRefs()

        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                } )
        Box(
            Modifier
                .size(bigSize.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.start)
                    end.linkTo(boxYellow.end)
                } )

        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                } )

        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)
                } )

        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                } )

        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                } )

        Box(
            Modifier
                .size(bigSize.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    bottom.linkTo(boxMagenta.top)
                    end.linkTo(boxMagenta.end)
                } )
        Box(
            Modifier
                .size(bigSize.dp)
                .background(Color.DarkGray)
                .constrainAs(boxDarkGray) {
                    bottom.linkTo(boxGreen.top)
                    start.linkTo(boxGreen.start)
                } )
        Box(
            Modifier
                .size(smallSize.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    bottom.linkTo(boxCyan.bottom)
                    top.linkTo(boxCyan.top)
                    start.linkTo(boxCyan.end)
                } )

    }
}

@Composable
fun ConstraintGuideExample(modifier: Modifier){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val redBox = createRef()
        val topGuide = createGuidelineFromTop( 0.1f )

        Box(
            Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(topGuide)
                }
        )

    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier){
    ConstraintLayout( modifier.fillMaxSize() ) {

        val (redBox, yellowBox, cyanBox) = createRefs()
        val barrier = createEndBarrier( redBox, yellowBox, )

        Box( Modifier.size( 65.dp ).background( Color.Red ).constrainAs( redBox ){
            top.linkTo( parent.top )
            start.linkTo( parent.start )
        })
        Box( Modifier.size( 200.dp ).background( Color.Yellow ).constrainAs( yellowBox ){
            top.linkTo( redBox.bottom, margin = 40.dp )
            start.linkTo( parent.start, margin = 32.dp )
        })


        Box( Modifier.size( 70.dp ).background( Color.Cyan ).constrainAs( cyanBox ){
            start.linkTo( barrier )
        })
    }
}

@Composable
fun ConstraintChain( modifier: Modifier ){
    ConstraintLayout( modifier.fillMaxSize() ) {

        val (redBox, yellowBox, cyanBox) = createRefs()

        Box( Modifier.size( 65.dp ).background( Color.Red ).constrainAs( redBox ){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(yellowBox.top)
        })
        Box( Modifier.size( 200.dp ).background( Color.Yellow ).constrainAs( yellowBox ){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(redBox.bottom)
            bottom.linkTo(cyanBox.top)
        })


        Box( Modifier.size( 70.dp ).background( Color.Cyan ).constrainAs( cyanBox ){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(yellowBox.bottom)
            bottom.linkTo(parent.bottom)
        })

        //CADENA
        createVerticalChain(redBox, yellowBox, cyanBox, chainStyle = ChainStyle.Packed)
    }
}