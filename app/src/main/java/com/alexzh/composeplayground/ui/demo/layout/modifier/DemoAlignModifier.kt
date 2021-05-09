package com.alexzh.composeplayground.ui.demo.layout.modifier

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Jetpack Compose: align modifier
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#modifiers-align
 */
@Preview(name = "align modifier")
@Composable
fun DemoAlign() {
    Box(
        modifier = Modifier.size(height = 120.dp, width = 300.dp)
    ) {
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "TopEnd", modifier = Modifier.align(Alignment.TopEnd))

        Text(text = "CenterStart", modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", modifier = Modifier.align(Alignment.CenterEnd))

        Text(text = "BottomStart", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
    }
}