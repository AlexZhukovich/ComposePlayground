package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

@Preview(group = "CoffeeDrinkItem-NightModeAndDevice", uiMode = UI_MODE_NIGHT_YES, device = Devices.AUTOMOTIVE_1024p, widthDp = 480, fontScale = 1.8f, showBackground = true)
@Preview(group = "CoffeeDrinkItem-NightModeAndDevice", uiMode = UI_MODE_NIGHT_YES, device = Devices.PIXEL_4, showBackground = true)
@Preview(group = "CoffeeDrinkItem-NightModeAndDevice", uiMode = UI_MODE_NIGHT_NO, device = Devices.AUTOMOTIVE_1024p, widthDp = 480, fontScale = 1.8f, showBackground = true)
@Preview(group = "CoffeeDrinkItem-NightModeAndDevice", uiMode = UI_MODE_NIGHT_NO, device = Devices.PIXEL_4, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_NightModeAndDevice_Annotation() {
    PlaygroundTheme {
        CoffeeDrinkItem2(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}

/**
 * The "PreviewProviders" file contains the following providers:
 * - [ColorProvider]
 * - [ScreenOrientationProvider]
 */
class ScreenOrientationToColorProvider : PairCombinedPreviewParameter<Int, Colors>(
    ScreenOrientationProvider() to ColorProvider()
)

@Preview(group = "CoffeeDrinkItem-NightModeAndDevice-Provider")
@Composable
fun Preview_CoffeeDrinkItem_NightModeAndDevice_Provider(
    @PreviewParameter(ScreenOrientationToColorProvider::class) orientationToColor: Pair<Int, Colors>
) {
    val configuration = Configuration().apply { orientation = orientationToColor.first }
    CompositionLocalProvider(LocalConfiguration provides Configuration(configuration)) {
        MaterialTheme(orientationToColor.second) {
            CoffeeDrinkItem2(
                title = "Espresso",
                ingredients = "Ground coffee, Water",
                icon = R.drawable.espresso_small
            )
        }
    }
}