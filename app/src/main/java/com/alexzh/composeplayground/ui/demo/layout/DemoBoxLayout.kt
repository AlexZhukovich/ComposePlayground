package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Jetpack Compose: Box layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-box
 */
@Preview(name = "Box layout")
@Composable
fun DemoBoxLayout_1() {
    Box(
        modifier = Modifier.size(height = 120.dp, width = 300.dp)
    ) {
        Text(text = "Very important text", fontSize = 20.sp)
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", fontSize = 20.sp)
    }
}

@Preview(name = "Box layout - align modifier")
@Composable
fun DemoBoxLayout_2() {
    Box(
        modifier = Modifier.size(height = 120.dp, width = 300.dp)
    ) {
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
    }
}