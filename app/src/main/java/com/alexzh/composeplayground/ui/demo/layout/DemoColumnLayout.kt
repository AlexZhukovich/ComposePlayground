package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
 * Jetpack Compose: Column layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-column
 */
@Preview(name = "Column layout")
@Composable
fun DemoColumnLayout_1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso"
        )
        Text(
            text = "Espresso",
            fontSize = 50.sp
        )
    }
}

@Preview(name = "Column layout - weight modifier")
@Composable
fun DemoColumnLayout_2() {
    Column(modifier = Modifier.height(200.dp)) {
        Text(
            text = "Very important text",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color.White)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.LightGray)
        )
    }
}