package com.alexzh.composeplayground.ui.demo.grid

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

/**
 * Jetpack Compose: LazyVerticalGrid use GridCells.Fixed(3)
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-building-grids/#lazyVerticalGrid-overview
 */
@ExperimentalFoundationApi
@Preview(name = "LazyVerticalGrid use GridCells.Fixed(3)")
@Composable
fun DemoLazyVerticalGrid_Fixed_3_Columns() {
    val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = item,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}

/**
 * Jetpack Compose: LazyVerticalGrid use GridCells.Fixed(7)
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-building-grids/#lazyVerticalGrid-limitations
 */
@ExperimentalFoundationApi
@Preview(name = "LazyVerticalGrid use GridCells.Fixed(7)")
@Composable
fun DemoLazyVerticalGrid_Fixed_5_Columns() {
    val data = listOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 9"
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(7),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = item,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

/**
 * Jetpack Compose: LazyVerticalGrid use GridCells.Adaptive(160.dp)
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-building-grids/#lazyVerticalGrid-overview
 */
@ExperimentalFoundationApi
@Preview(name = "LazyVerticalGrid use GridCells.Adaptive(160.dp) cells")
@Composable
fun DemoLazyVerticalGrid_Adaptive() {
    val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = item,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

/**
 * Jetpack Compose: Emoji Gallery
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-building-grids/#lazyVerticalGrid-example-emoji-gallery
 */
@ExperimentalFoundationApi
@Preview(name = "Emoji Gallery")
@Composable
fun DemoEmojiGallery() {
    val data = listOf("☕️", "🙂", "🥛", "🎉", "📐", "🎯", "🧩", "😄", "🥑")

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color(
                    red = Random.nextInt(0, 255),
                    green = Random.nextInt(0, 255),
                    blue = Random.nextInt(0, 255)
                )
            ) {
                Text(
                    text = item,
                    fontSize = 42.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}