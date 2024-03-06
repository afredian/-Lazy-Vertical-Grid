package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WoofDataClass(
    @DrawableRes val imageResourcesID: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

class WoofDataCollect() {
    fun WoofList(): List<WoofDataClass> {
        return listOf(
            WoofDataClass(R.drawable.koda, R.string.dog_name_1, 3, R.string.dog_description_1),
            WoofDataClass(R.drawable.faye, R.string.dog_name_2, 2, R.string.dog_description_2),
            WoofDataClass(R.drawable.frankie, R.string.dog_name_3, 4, R.string.dog_description_3),
            WoofDataClass(R.drawable.leroy, R.string.dog_name_4, 5, R.string.dog_description_4),
            WoofDataClass(R.drawable.moana, R.string.dog_name_5, 6, R.string.dog_description_5),
            WoofDataClass(R.drawable.lola, R.string.dog_name_6, 5, R.string.dog_description_6),
            WoofDataClass(R.drawable.nox, R.string.dog_name_7, 4, R.string.dog_description_7),
            WoofDataClass(R.drawable.tzeitel, R.string.dog_name_8, 3, R.string.dog_description_8),
            WoofDataClass(R.drawable.bella, R.string.dog_name_9, 2, R.string.dog_description_9),
            WoofDataClass(R.drawable.nox, R.string.dog_name_9, 1, R.string.dog_description_5)

        )
    }
}