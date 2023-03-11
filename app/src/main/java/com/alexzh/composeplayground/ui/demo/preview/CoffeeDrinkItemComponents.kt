package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.ui.demo.coffeedrinks.coffeeDrinks

@Composable
fun CoffeeDrinkItem(
    title: String,
    ingredients: String,
    @DrawableRes icon: Int
) {
    Row(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Surface(
            modifier = Modifier
                .size(72.dp)
                .padding(8.dp),
            shape = CircleShape,
            color = Color(0xFFFAFAFA)
        ) {
            Image(
                painter = BitmapPainter(ImageBitmap.imageResource(id = icon)),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column {
                val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
                Text(
                    text = title,
                    textAlign = if (isRtl) TextAlign.End else TextAlign.Start,
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                    style = TextStyle(fontSize = 24.sp),
                    color = MaterialTheme.colors.onBackground,
                    maxLines = 1
                )

                Text(
                    text = ingredients,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.54f),
                    maxLines = 1,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Composable
fun CoffeeDrinkItem2(
    title: String,
    ingredients: String,
    @DrawableRes icon: Int
) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        CoffeeDrinkItem2Landscape(title, ingredients, icon)
    } else {
        CoffeeDrinkItem2Portrait(title, ingredients, icon)
    }
}


@Composable
private fun CoffeeDrinkItem2Portrait(
    title: String,
    ingredients: String,
    @DrawableRes icon: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Surface(
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp),
            shape = CircleShape,
            color = Color(0xFFFAFAFA)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(icon),
                contentDescription = title,
                modifier = Modifier.size(100.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = ingredients,
                    style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.onBackground),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                )
            }
        }
    }
}

@Composable
private fun CoffeeDrinkItem2Landscape(
    title: String,
    ingredients: String,
    @DrawableRes icon: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            shape = CircleShape,
            color = Color(0xFFFAFAFA)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(icon),
                contentDescription = title,
                modifier = Modifier.size(100.dp)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground),
            modifier = Modifier.fillMaxWidth()
        )

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = ingredients,
                style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.onBackground),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun Demo_CoffeeDrinkItem2PortraitAlphaModifier() {
    val coffeeDrink = coffeeDrinks.first()

    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(coffeeDrink.image),
                contentDescription = coffeeDrink.name,
                modifier = Modifier.size(72.dp)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = coffeeDrink.name,
                    style = MaterialTheme.typography.h6,
                )

                Text(
                    text = coffeeDrink.description,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )

                Text(
                    text = "Ground coffee, Water",
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                )
            }
        }
    }
}