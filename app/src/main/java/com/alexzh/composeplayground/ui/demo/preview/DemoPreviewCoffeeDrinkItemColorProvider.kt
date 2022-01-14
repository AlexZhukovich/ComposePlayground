package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.alexzh.composeplayground.R

/**
 * The "PreviewProviders" file contains the [ColorProvider] provider.
 */
@Preview(group = "CoffeeDrinkItem-Colors", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_DarkAndLightColors(@PreviewParameter(ColorProvider::class) color: Colors) {
    MaterialTheme(color) {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}
