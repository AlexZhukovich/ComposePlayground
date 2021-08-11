package com.alexzh.composeplayground.ui.demo.addcomposable.composeview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.demo.addcomposable.TestComposable
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

class DemoComposeViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcomposable_composeview_demo)

        findViewById<ComposeView>(R.id.composeView)
            .setContent {
                PlaygroundTheme {
                    TestComposable(
                        text = "ComposeView",
                        backgroundColor = Color.Red
                    )
                }
            }
    }
}