package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

/**
 * The "PreviewProviders" file contains the [CoffeeDrinkProvider] provider.
 */
@Preview(group = "CoffeeDrinkItem-ContentFromProvider", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_ContentFromProvider(
    @PreviewParameter(CoffeeDrinkProvider::class) drink: CoffeeDrink
) {
    CoffeeDrinkItem(
        drink.name,
        drink.ingredients,
        drink.icon
    )
}