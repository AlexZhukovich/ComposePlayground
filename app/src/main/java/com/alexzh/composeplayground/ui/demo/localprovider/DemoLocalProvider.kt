package com.alexzh.composeplayground.ui.demo.localprovider

import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Demo_TextStyleAncOpacityLocalProviders() {
    CompositionLocalProvider(LocalTextStyle provides TextStyle(fontSize = 24.sp)) {
        Column(
            modifier = Modifier.size(300.dp, 200.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Text1")
                Text("Text2")
            }

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("Text3")
                    Text("Text4")
                }
            }

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("Text5")
                    Text("Text6")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Demo_TextStyleAncOpacityLocalProviders() {
    Demo_TextStyleAncOpacityLocalProviders()
}