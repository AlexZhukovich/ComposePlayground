package com.alexzh.composeplayground.ui.demo.layout.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Jetpack Compose: padding modifiers
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#modifiers-padding
 */
@Preview(name = "padding modifier")
@Composable
fun DemoPadding_1() {
    Box(
        modifier = Modifier
            .size(height = 120.dp, width = 200.dp)
            .background(Color.Magenta)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize()
                .background(Color.Blue)
        ) {

        }
    }
}

@Preview(name = "padding modifier")
@Composable
fun DemoPadding_2() {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .size(height = 120.dp, width = 200.dp)
            .background(Color.Magenta)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(80.dp)
                .background(Color.Blue)
        ) {

        }
    }
}