package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

@Preview(showBackground = true)
@Composable
fun Preview_MyComposable() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(400.dp)
    ) {
        Text(
            "Preview 🎉",
            fontSize = 56.sp
        )
    }
}

/**
 * Previews for the [Preview.name] and [Preview.group] parameters.
 */
@Preview(name = "green square", group = "square")
@Composable
fun Preview_GreenSquare() {
    ColorSquare(Color.Green)
}

@Preview(name = "yellow square", group = "square")
@Composable
fun Preview_YellowSquare() {
    ColorSquare(Color.Yellow)
}

@Composable
private fun ColorSquare(
    color: Color
) {
    Box(
        modifier = Modifier.size(400.dp)
            .background(color)
    )
}

/**
 * Preview for the [Preview.locale] parameter.
 */
@Preview(group = "CoffeeDrinkItem-Locale", locale = "en", showBackground = true)
@Preview(group = "CoffeeDrinkItem-Locale", locale = "ru", showBackground = true)
@Preview(group = "CoffeeDrinkItem-Locale", locale = "ar", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem() {
    CoffeeDrinkItem(
        title = stringResource(R.string.espresso_title),
        ingredients = stringResource(R.string.espresso_ingredients),
        icon = R.drawable.espresso_small
    )
}


/**
 * Preview for the [Preview.fontScale] parameter.
 */
@Preview(group = "CoffeeDrinkItem-FontScale", fontScale = 0.85f, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_SmallFontScale() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

@Preview(group = "CoffeeDrinkItem-FontScale", fontScale = 1.00f, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_DefaultFontScale() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

@Preview(group = "CoffeeDrinkItem-FontScale", fontScale = 1.15f, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_LargeFontScale() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

@Preview(group = "CoffeeDrinkItem-FontScale", fontScale = 1.30f, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_LargestFontScale() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

/**
 * Preview for the [Preview.showSystemUi] parameter.
 */
@Preview(group = "CoffeeDrinkItem-ShowSystemUI", showSystemUi = true, device = Devices.NEXUS_5)
@Composable
fun Preview_CoffeeDrinkItem_ShowSystemUI() {
    Column {
        repeat(7) {
            CoffeeDrinkItem(
                title = "Espresso",
                ingredients = "Ground coffee, Water",
                icon = R.drawable.espresso_small
            )
        }
    }
}

/**
 * Preview for the [Preview.showBackground] parameter.
 */
@Preview(group = "CoffeeDrinkItem-ShowBackground", showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_ShowBackground_True() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

@Preview(group = "CoffeeDrinkItem-ShowBackground", showBackground = false)
@Composable
fun Preview_CoffeeDrinkItem_ShowBackground_False() {
    CoffeeDrinkItem(
        title = "Espresso",
        ingredients = "Ground coffee, Water",
        icon = R.drawable.espresso_small
    )
}

/**
 * Preview for the [Preview.uiMode] parameter.
 */
@Preview(group = "CoffeeDrinkItem-UiModeNight", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(group = "CoffeeDrinkItem-UiModeNight", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun Preview_CoffeeDrinkItem_UiModeNight() {
    PlaygroundTheme {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}

/**
 * Preview for the [Preview.device] parameter.
 */
@Preview(group = "CoffeeDrinkItem-Device", showSystemUi = true, device = Devices.NEXUS_5)
@Composable
fun Preview_CoffeeDrinkItem_Device_Nexus5() {
    Column {
        repeat(7) {
            CoffeeDrinkItem(
                title = "Espresso",
                ingredients = "Ground coffee, Water",
                icon = R.drawable.espresso_small
            )
        }
    }
}

@Preview(group = "CoffeeDrinkItem-Device", showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun Preview_CoffeeDrinkItem_Device_Pixel4() {
    Column {
        repeat(7) {
            CoffeeDrinkItem(
                title = "Espresso",
                ingredients = "Ground coffee, Water",
                icon = R.drawable.espresso_small
            )
        }
    }
}

