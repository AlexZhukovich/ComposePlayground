package com.alexzh.composeplayground.ui.demo.layout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R
import kotlinx.coroutines.launch

/**
 * Jetpack Compose: Scaffold layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-scaffold
 */
@Preview(name = "Scaffold layout - topAppBar and content")
@Composable
fun DemoScaffoldLayout_1() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Title") })
        },
        content = {
            Text(
                modifier = Modifier.padding(it),
                text = "Content",
                fontSize = 40.sp
            )
        }
    )
}

data class NavigationItem(
    val title: String,
    @DrawableRes val iconRes: Int
)

/**
 * Jetpack Compose: Scaffold layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-scaffold
 */
@ExperimentalMaterialApi
@Preview(name = "Scaffold layout - drawer, topAppBar, bottomBar, floatingActionButton and content")
@Composable
fun DemoScaffoldLayout_2() {
    val bottomMenuItems = listOf(
        NavigationItem(title = "Item 1", iconRes = R.drawable.ic_one),
        NavigationItem(title = "Item 2", iconRes = R.drawable.ic_two),
        NavigationItem(title = "Item 3", iconRes = R.drawable.ic_three)
    )
    val drawerMenuItems = listOf(
        NavigationItem(title = "Section 1", iconRes = R.drawable.ic_one),
        NavigationItem(title = "Section 2", iconRes = R.drawable.ic_two),
        NavigationItem(title = "Section 3", iconRes = R.drawable.ic_three)
    )
    val selectedItem = remember { mutableStateOf(bottomMenuItems.first().title) }

    /**
     * By default, drawer state is closed, but we can customize it.
     *
     * Closed drawer state: `rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)`
     * Opened drawer state: `rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Open))`
     */
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn {
                items(drawerMenuItems) {
                    ListItem(
                        text = { Text(text = "Category ${it.title}") },
                        icon = {
                            Icon(
                                painter = painterResource(id = it.iconRes),
                                contentDescription = it.title
                            )
                        }
                    )
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Text(
                    text = selectedItem.value,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                bottomMenuItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = screen.title == selectedItem.value,
                        onClick = { selectedItem.value = screen.title },
                        label = { Text(screen.title) },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconRes),
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Button clicked")
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    )
}

@ExperimentalMaterialApi
@Preview(name = "Scaffold layout - topAppBar, bottomBar, floatingActionButton (in dock) and content")
@Composable
fun DemoScaffoldLayout_3() {
    val bottomMenuItems = listOf(
        NavigationItem(title = "Item 1", iconRes = R.drawable.ic_one),
        NavigationItem(title = "Item 2", iconRes = R.drawable.ic_two),
    )
    val selectedItem = remember { mutableStateOf(bottomMenuItems.first().title) }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") },
            )
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Button clicked")
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                bottomMenuItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = screen.title == selectedItem.value,
                        onClick = { selectedItem.value = screen.title },
                        label = { Text(screen.title) },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconRes),
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 8.dp,
                    end = 8.dp,
                    bottom = padding.calculateBottomPadding()
                )
            ) {
                itemsIndexed((1..30).toList()) { _, item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(72.dp)
                            .padding(bottom = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF263238).copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "$item", fontSize = 36.sp, color = Color(0xFF263238).copy(alpha = 0.8f))
                            }
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Item $item",
                                fontSize = 32.sp
                            )
                        }
                    }
                }
            }
        }
    )
}


















