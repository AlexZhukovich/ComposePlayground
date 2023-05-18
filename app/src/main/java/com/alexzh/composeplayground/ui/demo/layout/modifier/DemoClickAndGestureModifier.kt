package com.alexzh.composeplayground.ui.demo.layout.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Demo_ClickableModifier() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )

        Row {
            Text(
                text = "-1",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { count -= 1 }
            )
            Button(
                onClick = { count += 1},
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "+ 1")
            }
            Text(
                text = "+20 / -20",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = { count += 20 },
                            onLongPress = { count -= 20 }
                        )
                    }
            )
        }
    }
}