package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Density

class CoffeeDrinkFontScaleProvider : PreviewParameterProvider<Float> {
    override val values = sequenceOf(
        1.15f,
        0.85f
    )
}

class CoffeeDrinkToFontScaleProvider : PairCombinedPreviewParameter<CoffeeDrink, Float>(
    CoffeeDrinkProvider() to CoffeeDrinkFontScaleProvider()
)

@Preview(group = "CoffeeDrinkItem-CoffeeDrinkAndFrontScale", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_CoffeeDrinkAndFrontScale(
    @PreviewParameter(CoffeeDrinkToFontScaleProvider::class) coffeeDrinkToFontScale: Pair<CoffeeDrink, Float>
) {
    val currentDensity = LocalDensity.current.density
    CompositionLocalProvider(LocalDensity provides Density(currentDensity, fontScale = coffeeDrinkToFontScale.second)) {
        val coffeeDrink = coffeeDrinkToFontScale.first
        CoffeeDrinkItem(
            coffeeDrink.name,
            coffeeDrink.ingredients,
            coffeeDrink.icon
        )
    }
}