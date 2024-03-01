package com.example.myapplication

import android.content.res.Resources.Theme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class DataClass(
    @StringRes val stringReferenceID:Int,
    @DrawableRes val imageReferenceID:Int
)
class DataStore(){
    fun DataAllHere():List<DataClass>{
        return listOf(
            DataClass(R.string.affirmation1, R.drawable.image1),
            DataClass(R.string.affirmation2, R.drawable.image2),
            DataClass(R.string.affirmation3, R.drawable.image3),
            DataClass(R.string.affirmation4, R.drawable.image4),
            DataClass(R.string.affirmation5, R.drawable.image5),
            DataClass(R.string.affirmation6, R.drawable.image6),
            DataClass(R.string.affirmation7, R.drawable.image6),
            DataClass(R.string.affirmation8, R.drawable.image1),
            DataClass(R.string.affirmation9, R.drawable.image10)
        )
    }
}

@Composable
fun DataCard(modifier: Modifier = Modifier, dataClass: DataClass){

    Card(
        modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){

            Image(painter = painterResource(id = dataClass.imageReferenceID),
                contentDescription ="Image",
                modifier = modifier
                    .size(70.dp),
                contentScale = ContentScale.Crop)
            Spacer(modifier = modifier.width(16.dp))
            Column{
                Text(text = "Hello", modifier = modifier
                    .padding(start = 10.dp))
                Spacer(modifier = modifier.height(10.dp))
                Row {
                    Icon(imageVector = Icons.Filled.AccountBox,
                        contentDescription = "Icons")
                    Spacer(modifier = modifier.width(8.dp))
                    Text(text = "165")
                }
            }
        }
    }
}

@Composable
fun DataList(modifier: Modifier = Modifier, dataClass: List<DataClass>) {
    LazyVerticalGrid(columns =GridCells.Fixed(2), modifier = modifier.background(Color.Gray)){
        items(dataClass.size){
            DataCard(dataClass = dataClass[it])
        }
    }
}

@Preview
@Composable
fun Greeing() {
    DataList(dataClass = DataStore().DataAllHere())
}