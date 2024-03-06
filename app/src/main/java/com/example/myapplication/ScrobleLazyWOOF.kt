package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.WoofTheme
import com.example.myapplication.ui.theme.md_theme_dark_tertiary
import com.example.myapplication.ui.theme.md_theme_light_onTertiary
import com.example.myapplication.ui.theme.md_theme_light_primaryContainer

@Composable
fun WoofCard(
    modifier: Modifier = Modifier,
    @DrawableRes DogImage: Int,
    @StringRes DogName: Int,
    DogAge: Int,
    @StringRes DogHobbies: Int
) {
    var isExpand by remember {
        mutableStateOf(false)
    }
    val cardColor = if (isSystemInDarkTheme()) {
        md_theme_dark_tertiary
    } else {
        md_theme_light_primaryContainer
    }

    Card(
        modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(cardColor)
    ) {
        Column(
            modifier
                .clickable { isExpand = !isExpand })
        {

            Row(
                modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isExpand) "▼" else "▶",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    painter = painterResource(id = DogImage),
                    contentDescription = "Image",
                    modifier
                        .clip(CircleShape)
                        .size(80.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.padding(start = 10.dp)
                ) {
                    Text(text = stringResource(id = DogName), modifier.padding(bottom = 6.dp))
                    Text(text = "$DogAge Years Old")
                    if (isExpand) {
                        Text(text = stringResource(id = DogHobbies))
                    }
                }
            }
        }
    }
}

@Composable
fun WoofNavBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
            Image(
                painter = painterResource(id = R.drawable.foot2),
                contentDescription = "WoofNavBar",
                modifier = Modifier.clip(CircleShape)
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Woof",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
    }
}


@Composable
fun WoofCardList(modifier: Modifier = Modifier, woofDataClass: List<WoofDataClass>) {
    Column{
        WoofNavBar(modifier.fillMaxWidth())
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(woofDataClass.size) {
            WoofCard(
                DogImage = woofDataClass[it].imageResourcesID,
                DogName = woofDataClass[it].name,
                DogAge = woofDataClass[it].age,
                DogHobbies = woofDataClass[it].hobbies
            )
        }
    }
    }
}


@Preview(showBackground = true)
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) {
        WoofCardList(woofDataClass = WoofDataCollect().WoofList())
    }
}