package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R
import kotlinx.coroutines.launch

/**
 * Jetpack Compose: BackdropScaffold layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-backdrop-scaffold
 */
@ExperimentalMaterialApi
@Preview("BackdropScaffold layout")
@Composable
fun DemoBackdropScaffoldLayout_1() {
    val scope = rememberCoroutineScope()

    val menuItems = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10"
    )
    val selectedItem = remember { mutableStateOf(menuItems.first()) }
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            TopAppBar(
                title = { Text("Title") },
                navigationIcon = {
                    if (scaffoldState.isConcealed) {
                        IconButton(onClick = { scope.launch { scaffoldState.reveal() } }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_menu),
                                contentDescription = "Open menu"
                            )
                        }
                    } else {
                        IconButton(onClick = { scope.launch { scaffoldState.conceal() } }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_back),
                                contentDescription = "Close menu"
                            )
                        }
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )

        },
        backLayerContent = {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(menuItems) {
                    ListItem(
                        text = { Text(text = it) },
                        modifier = Modifier.clickable {
                            selectedItem.value = it
                            scope.launch { scaffoldState.conceal() }
                        }
                    )
                }
            }
        },
        frontLayerContent = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = selectedItem.value,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}