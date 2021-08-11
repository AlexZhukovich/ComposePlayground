package com.alexzh.composeplayground.ui.demo.addcomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestComposable(
    text: String,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 24.sp
        )
    }
}

@Preview
@Composable
fun Demo_TestComposable() {
    TestComposable(text = "Hello World!", backgroundColor = Color.Yellow)
}