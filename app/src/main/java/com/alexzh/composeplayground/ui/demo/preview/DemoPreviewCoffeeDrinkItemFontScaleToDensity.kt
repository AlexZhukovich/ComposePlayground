package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Density
import com.alexzh.composeplayground.R

class CustomFontScaleProvider : PreviewParameterProvider<Float> {
    override val values = sequenceOf(
        0.85f,    // Small
        1.0f,     // Default
        1.15f,    // Large
    )
}

class CustomDensityProvider : PreviewParameterProvider<Float> {
    override val values = sequenceOf(
        2.125f,   // Small
        2.5f,     // Default
        2.7875f,  // Large
    )
}

class DensityToFontScaleProvider : PairCombinedPreviewParameter<Float, Float>(
    CustomDensityProvider() to CustomFontScaleProvider()
)

@Preview(group = "CoffeeDrinkItem-DensityToFontScale-Provider", showBackground = true, widthDp = 320)
@Composable
fun Preview_CoffeeDrinkItem_DensityAndFontScale_Provider(
    @PreviewParameter(DensityToFontScaleProvider::class) densityToFontScale: Pair<Float, Float>
) {

    CompositionLocalProvider(
        LocalDensity provides Density(
            density = densityToFontScale.first,
            fontScale = densityToFontScale.second
        )
    ) {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}