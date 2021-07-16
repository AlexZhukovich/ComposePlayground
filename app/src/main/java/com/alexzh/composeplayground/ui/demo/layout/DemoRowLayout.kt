package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R

/**
 * Jetpack Compose: Row layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-row
 */
@Preview(name = "Row layout")
@Composable
fun DemoRowLayout_1() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Espresso",
            fontSize = 30.sp
        )
    }
}

@Preview(name = "Row layout - weight modifier")
@Composable
fun DemoRowLayout_2() {
    Row(modifier = Modifier.height(200.dp)) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(Color.White)
        )
        Text(
            text = "Very important text",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.LightGray)
        )
    }
}