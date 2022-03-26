package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import androidx.compose.material.Colors
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.LayoutDirection
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.theme.DarkColorPalette
import com.alexzh.composeplayground.ui.theme.LightColorPalette

class CoffeeDrinkProvider : PreviewParameterProvider<CoffeeDrink> {
    override val values = sequenceOf(
        CoffeeDrink(
            "Espresso",
            "Ground coffee, Water",
            R.drawable.espresso_small
        ),
        CoffeeDrink(
            "Frappino",
            "Espresso, Cold milk, Sugar, Ice cubes, Irish Cream flavoured syrup, Whipped cream, Chocolate sauce",
            R.drawable.frappino_small
        )
    )
}

class ColorProvider : PreviewParameterProvider<Colors> {
    override val values: Sequence<Colors>
        get() = sequenceOf(DarkColorPalette, LightColorPalette)
}

class ScreenOrientationProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = sequenceOf(
            Configuration.ORIENTATION_LANDSCAPE,
            Configuration.ORIENTATION_PORTRAIT
        )
}

class LayoutDirectionProvider : PreviewParameterProvider<LayoutDirection> {
    override val values: Sequence<LayoutDirection>
        get() = sequenceOf(
            LayoutDirection.Rtl,
            LayoutDirection.Ltr
        )
}

