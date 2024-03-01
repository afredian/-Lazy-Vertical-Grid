package com.example.myapplication

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun DiceRoller(modifier: Modifier = Modifier){
    var dice by remember {
        mutableStateOf(0)
    }
    val DiceList = when(dice){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        6->R.drawable.dice_6
        else -> R.drawable.dice_1
    }
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = DiceList),
            contentDescription ="DiceImage", modifier.size(100.dp))
        Button(onClick = {dice = (1..6).random()},
            colors = ButtonDefaults.buttonColors(Color.Black),
            elevation = ButtonDefaults.buttonElevation(16.dp),
            content = { Text(text = "Click")}
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DicePreview() {
    DiceRoller()
}