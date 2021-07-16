package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R

/**
 * Jetpack Compose: Combination of Row and Column layouts
 */
@Preview(name = "Combination of Row and Column layouts - coffee drink card")
@Composable
fun DemoColumnAndRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier.size(100.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Espresso",
                fontSize = 24.sp
            )
            Text(
                text = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                style = TextStyle(textAlign = TextAlign.Justify)
            )
        }
    }
}