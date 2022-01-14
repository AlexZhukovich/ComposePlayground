package com.alexzh.composeplayground.ui.demo.preview

import androidx.annotation.DrawableRes

data class CoffeeDrink(
    val name: String,
    val ingredients: String,
    @DrawableRes val icon: Int
)