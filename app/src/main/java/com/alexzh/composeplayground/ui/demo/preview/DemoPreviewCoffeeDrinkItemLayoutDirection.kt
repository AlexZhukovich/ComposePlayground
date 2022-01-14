package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.LayoutDirection
import com.alexzh.composeplayground.R

/**
 * The "PreviewProviders" file contains the [LayoutDirectionProvider] provider.
 */
@Preview(group = "CoffeeDrinkItem-LTR-and-RTL-Provider", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_LTR_and_RTL_Provider(
    @PreviewParameter(LayoutDirectionProvider::class) layoutDirection: LayoutDirection
) {
    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}