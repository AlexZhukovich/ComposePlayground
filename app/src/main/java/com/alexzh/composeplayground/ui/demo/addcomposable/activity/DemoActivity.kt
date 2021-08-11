package com.alexzh.composeplayground.ui.demo.addcomposable.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.alexzh.composeplayground.ui.demo.addcomposable.TestComposable
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

class DemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    TestComposable(
                        text = "Activity",
                        backgroundColor = Color.DarkGray
                    )
                }
            }
        }
    }
}