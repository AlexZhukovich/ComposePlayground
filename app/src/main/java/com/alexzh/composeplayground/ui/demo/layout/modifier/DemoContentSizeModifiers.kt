package com.alexzh.composeplayground.ui.demo.layout.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Jetpack Compose: content size modifiers
 * - height, width, size
 * - fillMaxHeight, fillMaxWidth, fillMaxSize
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#modifiers-set-content-size
 */
@Preview(name = "Different values for height & width modifiers")
@Composable
fun DemoHeightAndWidth_1() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(200.dp)
            .background(Color.Magenta)
    ) {

    }
}

@Preview(name = "Similar values for height & width modifiers")
@Composable
fun DemoHeightAndWidth_2() {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(Color(0xFF342E6C))
    ) {

    }
}

@Preview(name = "size modifier")
@Composable
fun DemoSize_1() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
    ) {

    }
}

@Preview(name = "fillMaxWidth modifier")
@Composable
fun DemoFillMaxWidth() {
    Box(
        modifier = Modifier
            .size(height = 100.dp, width = 200.dp)
            .background(Color(0xFFCA8DC4))
    ) {
        Box(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .background(Color(0xFF342E6C))
        ) {

        }
    }
}