package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

const val TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

@Composable
private fun TestComposable(
    title: String,
    subtitle: String,
    text: String
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.h1
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.h3
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun Demo_Preview_1() {
    PlaygroundTheme {
        TestComposable(
            title = "Title 1",
            subtitle = "Subtitle 1",
            text = TEXT
        )
    }
}

@Preview(widthDp = 720, heightDp = 320, showBackground = true)
@Composable
fun Demo_Preview_3() {
    PlaygroundTheme(darkTheme = true) {
        TestComposable(
            title = "Title 3",
            subtitle = "Subtitle 3",
            text = TEXT
        )
    }
}