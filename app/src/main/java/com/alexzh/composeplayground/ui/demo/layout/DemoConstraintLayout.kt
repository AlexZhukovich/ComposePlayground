package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alexzh.composeplayground.R

/**
 * Jetpack Compose: ConstraintLayout layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-constraint-layout
 */
@Preview(name = "ConstraintLayout - coffee drink card")
@Composable
fun DemoConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (logo, title, description) = createRefs()

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier
                .size(100.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "Espresso",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                linkTo(start = logo.end, end = parent.end, startMargin = 8.dp, endMargin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )
        Text(
            text = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
            style = TextStyle(textAlign = TextAlign.Justify),
            modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom)
                linkTo(start = title.start, end = title.end)
                width = Dimension.fillToConstraints
            }
        )
    }
}