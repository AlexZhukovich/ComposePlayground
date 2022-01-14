package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.LayoutDirection
import com.alexzh.composeplayground.R

/**
 * The "PreviewProviders" file contains the following providers:
 * - [ScreenOrientationProvider]
 * - [ColorProvider]
 * - [LayoutDirectionProvider]
 */
class ScreenOrientationColorsAndLayoutDirectionsProvider : TripleCombinedPreviewParameter<Int, Colors, LayoutDirection>(
    Triple(
        ScreenOrientationProvider(),
        ColorProvider(),
        LayoutDirectionProvider()
    )
)

@Preview
@Composable
fun Preview_ScreenOrientationAndColorsAndLayoutDirections(
    @PreviewParameter(ScreenOrientationColorsAndLayoutDirectionsProvider::class) config: Triple<Int, Colors, LayoutDirection>
) {
    val configuration = Configuration().apply { orientation = config.first }
    CompositionLocalProvider(LocalConfiguration provides Configuration(configuration)) {
        CompositionLocalProvider(LocalLayoutDirection provides config.third) {
            MaterialTheme(colors = config.second) {
                CoffeeDrinkItem2(
                    title = "Espresso",
                    ingredients = "Ground coffee, Water",
                    icon = R.drawable.espresso_small
                )
            }
        }
    }
}






