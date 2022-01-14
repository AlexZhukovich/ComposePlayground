package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.alexzh.composeplayground.R

@Preview(group = "CoffeeDrinkItem-LandscapeAndPortrait-Annotation", showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 480)
@Preview(group = "CoffeeDrinkItem-LandscapeAndPortrait-Annotation", showBackground = true, widthDp = 420)
@Composable
fun Preview_CoffeeDrinkItem_LandscapeAndPortraitAnnotation() {
    CoffeeDrinkItem2(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

/**
 * The "PreviewProviders" file contains the [ScreenOrientationProvider] provider.
 */
@Preview(group = "CoffeeDrinkItem-LandscapeAndPortrait-Provider", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_LandscapeAndPortraitProvider(
    @PreviewParameter(ScreenOrientationProvider::class) screenOrientation: Int
) {
    val configuration = Configuration().apply { orientation = screenOrientation }
    CompositionLocalProvider(LocalConfiguration provides Configuration(configuration)) {
        CoffeeDrinkItem2(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}